package br.com.ctw.api_monitoramento_transformadores.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Define a Entidade de Alerta Termico, possui relacionamento com Transformador (N:1) e com Leitura Termica (1:N)
 */
@Entity
@Table(name = "alerta_termico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AlertaTermico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "data_alerta",
            nullable = false
    )
    private LocalDateTime dataAlerta;

    @Column(
            name = "tipo",
            length = 30,
            nullable = false
    )
    private String tipo;

    @Column(
            name = "descricao",
            nullable = false
    )
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "transformador_id",
            nullable = false
    )
    private Transformador transformador;

    @OneToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "leitura_id",
            nullable = false
    )
    private LeituraTermica leitura;

}
