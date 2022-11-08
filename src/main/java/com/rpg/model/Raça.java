package com.rpg.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_raça")
public class Raça {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é uma informação obrigatória.")
    @Size(min = 1, max = 100)
    private String nome;
    
    @NotBlank(message = "Subraça é uma informação obrigatória.")
    @Size(min = 1, max = 100)
    private String subraça;

    @Size(min = 3, max = 2000)
    private String biografia;
	
}
