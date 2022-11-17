package com.rpg.service;

import com.rpg.model.Classe;
import com.rpg.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    public Optional<Classe> cadastrarClasse(Classe classe) {

        List<Classe> allClasse = classeRepository.findAll();

        for(Classe classeChecagem : allClasse) {
            if(classeChecagem.getNome().equals(classe.getNome())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Classe já cadastrada.");
            }
        }

        return Optional.of(classeRepository.save(classe));
    }

    public Optional<Classe> atualizarClasse(Classe classe) {

        List<Classe> allClasse = classeRepository.findAll();

        for(Classe classeChecagem : allClasse) {
            if(classeChecagem.getNome().equals(classe.getNome())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Classe já cadastrada.");
            }
        }

        return Optional.of(classeRepository.save(classe));
    }

    public Optional<Classe> deletarClasse(Long id) {

        Optional<Classe> classe = classeRepository.findById(id);

        if(classe.isPresent()) {
            classeRepository.deleteById(id);
            return classe;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Classe não encontrada.");
        }
    }

}
