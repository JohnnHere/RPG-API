package com.rpg.controller;

import com.rpg.model.Classe;
import com.rpg.repository.ClasseRepository;
import com.rpg.service.ClasseService;
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

    @Autowired
    private ClasseService classeService;

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
    public ResponseEntity<Classe> post(@Valid @RequestBody Classe classe) {

        return classeService.cadastrarClasse(classe)
                .map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

    }

    @PutMapping
    public ResponseEntity<Classe> put(@Valid @RequestBody Classe classe) {

        return classeService.atualizarClasse(classe)
                .map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        classeService.deletarClasse(id);
        
    }

}
