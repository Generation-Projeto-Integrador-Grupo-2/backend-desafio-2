package com.rebu98.rebu98.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.rebu98.rebu98.model.Motorista;
import com.rebu98.rebu98.model.TipoUsuario;
import com.rebu98.rebu98.model.Usuario;
import com.rebu98.rebu98.repository.MotoristaRepository;
import com.rebu98.rebu98.repository.UsuarioRepository;

@Service
public class MotoristaService {
	@Autowired
	private MotoristaRepository motoristaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Motorista cadastrarMotorista(Motorista motorista) {
		Usuario usuario = motorista.getUsuario();
		if (usuario != null) {
			usuario.setTipo(TipoUsuario.MOTORISTA);
			usuarioRepository.save(usuario);
		}

		return motoristaRepository.save(motorista);
	}

	public Optional<Motorista> atualizarMotorista(Motorista motorista) {
		Optional<Motorista> motoristaAtualizado = motoristaRepository.findById(motorista.getId());

		if (motoristaAtualizado.isPresent()) {
			Motorista m = motoristaAtualizado.get();
			m.setCnh(motorista.getCnh());
			m.setModeloCarro(motorista.getModeloCarro());
			m.setPlaca(motorista.getPlaca());

			Usuario usuario = m.getUsuario();
			if (usuario != null) {
				usuario.setTipo(TipoUsuario.MOTORISTA);
				usuarioRepository.save(usuario);
			}

			return Optional.ofNullable(motoristaRepository.save(m));
		}

		return Optional.empty();
	}
}

