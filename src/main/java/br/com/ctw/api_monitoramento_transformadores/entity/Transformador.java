package br.com.ctw.api_monitoramento_transformadores.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Define a Entidade de Transformador, possui relacionamento com Técnico (N:M), Alerta Térmico (1:N) e Leitura Térmica (1:N),
 * é proibido criar um Transformador que possui duplicidade de Número de Série de outro Transformador.
 */
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "transformador_tecnico",
            joinColumns = @JoinColumn(name = "transformador_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnico_id")
    )
    private Set<Tecnico> tecnicos = new HashSet<>();

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "transformador",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<LeituraTermica> leituras = new HashSet<>();

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "transformador",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<AlertaTermico> alertas = new HashSet<>();

}
