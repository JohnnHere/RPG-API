package com.rpg.repository;

import com.rpg.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
    public List<Classe> findAllByNomeContainingIgnoreCase(String nome);

}
