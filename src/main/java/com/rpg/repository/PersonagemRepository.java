package com.rpg.repository;

import com.rpg.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

    public List<Personagem> findAllByNomeContainingIgnoreCase(String nome);

}

