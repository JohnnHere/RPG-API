package com.rpg.controller;

import com.rpg.model.Raca;
import com.rpg.repository.RacaRepository;
import com.rpg.service.RacaService;
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
public class RacaController {

    @Autowired
    private RacaRepository racaRepository;

    @Autowired
    private RacaService racaService;

    @GetMapping
    public ResponseEntity<List<Raca>> getAll() { return ResponseEntity.ok(racaRepository.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<Raca> getById(Long id) {
        return racaRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Raca>> getByName(String nome) {
        return ResponseEntity.ok(racaRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<Raca> post(@Valid @RequestBody Raca raca) {

        return racaService.cadastrarRaca(raca)
                .map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

    }

    @PutMapping
    public ResponseEntity<Raca> put(@Valid @RequestBody Raca raca) {

        return racaService.atualizarRaca(raca)
                .map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        racaService.deletarRaca(id);
        
    }
}
