package br.com.ctw.api_monitoramento_transformadores.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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
            unique = true,
            nullable = false
    )
    private String cpf;

    @Column(
            name = "especialidade",
            nullable = false
    )
    private String especialidade;

    @Column(
            name = "email",
            nullable = false
    )
    private String email;

    @ManyToMany(mappedBy = "tecnicos")
    Set<Transformador> transformadores = new HashSet<>();

}
