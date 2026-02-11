package com.example.Secretaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "observacao")
public class Observacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    @NotNull(message = "campo 'aluno_id' não pode ser vazio")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    @NotNull(message = "campo 'professor_id' não pode ser vazio")
    private Professor professor;

    @NotNull(message = "campo 'texto' não pode ser vazio")
    private String texto;

    @Column(name = "data_criacao")
    @NotNull(message = "campo 'dataCriacao' não pode ser vazio")
    private OffsetDateTime dataCriacao;
}
