package br.com.ctw.api_monitoramento_transformadores.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

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
            name = "descricao"
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
