package br.com.ctw.api_monitoramento_transformadores.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "transformador")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Transformador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "transformador_id",
            nullable = false
    )
    private Long id;

    @Column(
            name = "numero_serie",
            length = 50,
            unique = true,
            nullable = false
    )
    private String numeroSerie;

    @Column(
            name = "modelo",
            length = 100,
            nullable = false
    )
    private String modelo;

    @Column(
            name = "subestacao",
            length = 100,
            nullable = false
    )
    private String subestacao;

    @Column(
            name = "potencia_kva",
            nullable = false
    )
    private BigDecimal potenciaKva;

    @Column(
            name = "limite_temp_enrol",
            nullable = false
    )
    private BigDecimal limiteTemperaturaEnrolamento;

    @Column(
            name = "limite_temp_oleo",
            nullable = false
    )
    private BigDecimal limiteTemperaturaOleo;

    @ElementCollection
    private Set<Tecnico> tecnicos = new HashSet<>();

    @OneToMany(
            mappedBy = "transformador",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    Set<LeituraTermica> leituras = new HashSet<>();

    @OneToMany(
            mappedBy = "transformador",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    Set<AlertaTermico> alertas = new HashSet<>();

}
