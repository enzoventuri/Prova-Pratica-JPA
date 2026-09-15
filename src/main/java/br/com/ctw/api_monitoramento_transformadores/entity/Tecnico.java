package br.com.ctw.api_monitoramento_transformadores.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Define a Entidade dos Técnicos, possui relacionamento com Transformador (N:M),
 * é proibido cadastrar um Técnico com o mesmo CPF que outro.
 */
@Entity
@Table(name = "tecnico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "nome",
            length = 100,
            nullable = false
    )
    private String nome;

    @Column(
            name = "cpf",
            length = 20,
            unique = true,
            nullable = false
    )
    private String cpf;

    @Column(
            name = "especialidade",
            length = 50,
            nullable = false
    )
    private String especialidade;

    @Column(
            name = "email",
            length = 50,
            nullable = false
    )
    private String email;

    @ManyToMany(mappedBy = "tecnicos", fetch = FetchType.LAZY)
    private Set<Transformador> transformadores = new HashSet<>();

}
