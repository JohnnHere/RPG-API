package com.rpg.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_raca")
public class Raca {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é uma informação obrigatória.")
    @Size(min = 1, max = 100)
    private String nome;
    
    @NotBlank(message = "Subraca é uma informação obrigatória.")
    @Size(min = 1, max = 100)
    private String subraca;

    @Size(min = 3, max = 2000)
    private String biografia;

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

	public String getSubraca() {
		return subraca;
	}

	public void setSubraca(String subraca) {
		this.subraca = subraca;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	
}
