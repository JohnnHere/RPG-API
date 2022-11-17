package com.rpg.controller;

import com.rpg.model.Classe;
import com.rpg.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/raca")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClasseController {

    @Autowired
    private ClasseRepository classeRepository;

    @GetMapping
    public ResponseEntity<List<Classe>> getAll() {
        return ResponseEntity.ok(classeRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classe> getById(Long id) {
        return classeRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Classe>> getByName(String nome) {
        return ResponseEntity.ok(classeRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<Classe> postClasse(@Valid @RequestBody Classe classe) {

        return ResponseEntity.status(HttpStatus.CREATED).body(classeRepository.save(classe));

    }

}
