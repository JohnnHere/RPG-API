package com.rpg.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_personagem")
public class Personagem {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Nome é uma informação obrigatória.")
    @Size(min = 1, max = 100)
    private String nome;

    @NotBlank(message = "Gênero é uma informação obrigatória.")
    @Size(min = 1, max = 20)
    private String genero;

    @Size(min = 3, max = 2000)
    private String biografia;

    @Size(min = 2, max = 500)
    private String habilidadeAncestral;

    @NotBlank(message = "Idade é uma informação obrigatória.")
    @Size(min = 1, max = 100)
    private int idade;

    @NotBlank(message = "Nível é uma informação obrigatória.")
    @Size(min = 1, max = 100)
    private int nivel;

    @ManyToOne
    private Raca raca;

    @ManyToOne
    private Classe classe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getHabilidadeAncestral() {
        return habilidadeAncestral;
    }

    public void setHabilidadeAncestral(String habilidadeAncestral) {
        this.habilidadeAncestral = habilidadeAncestral;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
