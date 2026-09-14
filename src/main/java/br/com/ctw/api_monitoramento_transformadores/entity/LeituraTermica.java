package br.com.ctw.api_monitoramento_transformadores.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "leitura_termica")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LeituraTermica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "temp_oleo",
            precision = 5,
            secondPrecision = 2,
            nullable = false
    )
    private BigDecimal temperaturaOleo;

    @Column(
            name = "temp_enrolamento",
            precision = 5,
            secondPrecision = 2,
            nullable = false
    )
    private BigDecimal temperaturaEnrolamento;

    @Column(
            name = "data_hora_leitura",
            nullable = false
    )
    private LocalDateTime dataHoraLeitura;

    @ManyToOne
    @JoinColumn(
            name = "transformador_id",
            nullable = false
    )
    private Transformador transformador;

    @OneToOne(
            mappedBy = "leitura",
            cascade = CascadeType.ALL
    )
    private AlertaTermico alerta;

}
