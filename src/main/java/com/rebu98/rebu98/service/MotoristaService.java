package com.rebu98.rebu98.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import com.rebu98.rebu98.dto.MotoristaRequestDTO;
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

	public Motorista cadastrarMotorista(MotoristaRequestDTO motoristaRequest) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();

		return usuarioRepository.findByEmail(email).map(usuario -> {

			if (usuario.getMotorista() != null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"Usuário já é motorista!");
			}

			usuario.setTipo(TipoUsuario.MOTORISTA);
			usuarioRepository.save(usuario);

			Motorista motorista = new Motorista();
			motorista.setCnh(motoristaRequest.cnh());
			motorista.setModeloCarro(motoristaRequest.modeloCarro());
			motorista.setPlaca(motoristaRequest.placa());
			motorista.setUsuario(usuario);

			return motoristaRepository.save(motorista);
		}).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
	}

	public Optional<Motorista> buscarPorId(Long id) {
		return motoristaRepository.findById(id);
	}

	public List<Motorista> listarMotoristas() {
		return motoristaRepository.findAll();
	}

	public Optional<Motorista> buscarPorCnh(String cnh) {
		return motoristaRepository.findAllByCnhContainingIgnoreCase(cnh);
	}

	public Optional<List<Motorista>> buscarPorModeloCarro(String modeloCarro) {
		return motoristaRepository.findAllByModeloCarroContainingIgnoreCase(modeloCarro);
	}

	public Optional<Motorista> buscarPorPlaca(String placa) {
		return motoristaRepository.findAllByPlacaContainingIgnoreCase(placa);
	}

	public Optional<Motorista> atualizarMotorista(MotoristaRequestDTO motoristaRequest) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();

		return usuarioRepository.findByEmail(email).flatMap(usuario -> {
			if (usuario.getMotorista() == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"Usuário não é um motorista cadastrado!");
			}

			Motorista motorista = usuario.getMotorista();
			motorista.setCnh(motoristaRequest.cnh());
			motorista.setModeloCarro(motoristaRequest.modeloCarro());
			motorista.setPlaca(motoristaRequest.placa());

			usuario.setTipo(TipoUsuario.MOTORISTA);
			usuarioRepository.save(usuario);

			return Optional.of(motoristaRepository.save(motorista));
		});
	}

	public void delete(@PathVariable Long id) {
		Optional<Motorista> motorista = motoristaRepository.findById(id);

		if (motorista.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		motoristaRepository.deleteAll();
	}
}
