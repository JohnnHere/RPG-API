package com.rpg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpg.repository.RacaRepository;

@Service
public class RacaService {
	
	@Autowired
	RacaRepository racaRepository;

}
