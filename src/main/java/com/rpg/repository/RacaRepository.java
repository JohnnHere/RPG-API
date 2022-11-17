package com.rpg.repository;

import com.rpg.model.Raca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RacaRepository extends JpaRepository <Raca, Long> {
    public List<Raca> findAllByNomeContainingIgnoreCase(String nome);

}
