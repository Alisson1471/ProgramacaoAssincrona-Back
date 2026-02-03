package com.example.Secretaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nota")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "campo 'titulo' não pode ser vazio")
    private String titulo;

    @NotNull(message = "campo 'valor' não pode ser vazio")
    @Column(precision = 10, scale = 2) // Alinha com o DECIMAL(10,2) do seu SQL
    private BigDecimal valor;

    @OneToOne
    @JoinColumn(name = "professor_id")
    @NotNull(message = "campo 'professor_id' não pode ser vazio")
    private Professor professor;

    @OneToOne
    @JoinColumn(name = "disciplina_id")
    @NotNull(message = "campo 'disciplina_id' não pode ser vazio")
    private Disciplina disciplina;

    @OneToOne
    @JoinColumn(name = "aluno_id")
    @NotNull(message = "campo 'aluno_id' não pode ser vazio")
    private Aluno aluno;

}
