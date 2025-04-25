package com.rebu98.rebu98.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.rebu98.rebu98.model.Motorista;
import com.rebu98.rebu98.repository.MotoristaRepository;

@Service
public class MotoristaService {
	@Autowired
	private MotoristaRepository motoristaRepository;

	public Motorista cadastrarMotorista(Motorista motorista) {
		return motoristaRepository.save(motorista);
	}

	public Optional<Motorista> atualizarMotorista(Motorista motorista) {
		Optional<Motorista> motoristaAtualizado = motoristaRepository.findById(motorista.getId());

		if (motoristaAtualizado.isPresent()) {

			motoristaAtualizado.get().setId(motoristaAtualizado.get().getId());
            motoristaAtualizado.get().setCnh(motoristaAtualizado.get().getCnh());
            motoristaAtualizado.get().setModeloCarro(motoristaAtualizado.get().getModeloCarro());
            motoristaAtualizado.get().setPlaca(motoristaAtualizado.get().getPlaca());
			
			return Optional.ofNullable(motoristaRepository.save(motorista)); 
		}
		return Optional.empty();
	}
} 
