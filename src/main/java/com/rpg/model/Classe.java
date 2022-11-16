package com.rpg.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_classe")
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é uma informação obrigatória.")
    @Size(min = 1, max = 100)
    private String nome;

    @NotBlank(message = "Subraca é uma informação obrigatória.")
    @Size(min = 1, max = 100)
    private String especializacao;

    @Size(min = 3, max = 2000)
    private String descricao;

}
