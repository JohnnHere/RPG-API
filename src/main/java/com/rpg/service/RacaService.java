package com.rpg.service;

import com.rpg.model.Raca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rpg.repository.RacaRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RacaService {
	
	@Autowired
	RacaRepository racaRepository;

	public Optional<Raca> cadastrarRaca(Raca raca) {

		List<Raca> allRaca = racaRepository.findAll();

		for(Raca racaChecagem : allRaca) {
			if(racaChecagem.getNome().equals(raca.getNome())) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Raça já cadastrada.");
			}
		}

		return Optional.of(racaRepository.save(raca));
	}

	public Optional<Raca> atualizarRaca(Raca raca) {

		List<Raca> allRaca = racaRepository.findAll();

		for(Raca racaChecagem : allRaca) {
			if(racaChecagem.getNome().equals(raca.getNome())) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Raça já cadastrada.");
			}
		}

		return Optional.of(racaRepository.save(raca));
	}

	public Optional<Raca> deletarRaca(Long id) {

		Optional<Raca> raca = racaRepository.findById(id);

		if(raca.isPresent()) {
			racaRepository.deleteById(id);
			return raca;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Raça não encontrada.");
		}
	}

}
