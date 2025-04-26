package com.rebu98.rebu98.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.rebu98.rebu98.dto.CalculoTempoCorridaDTO;
import com.rebu98.rebu98.model.Corrida;
import com.rebu98.rebu98.model.Usuario;
import com.rebu98.rebu98.repository.CorridaRepository;
import com.rebu98.rebu98.repository.UsuarioRepository;

@Service
public class CorridaService {

	@Autowired
	private CorridaRepository corridaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Corrida cadastrarCorrida(Corrida corrida) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();

		return usuarioRepository.findByEmail(email).map(usuario -> {
			corrida.setUsuario(usuario);
			return corridaRepository.save(corrida);
		}).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
	}

	public Optional<Corrida> buscarPorId(Long id) {
		return corridaRepository.findById(id);
	}

	public List<Corrida> buscarCorridasPorUsuario(Long usuarioId) {
		return corridaRepository.findByUsuarioId(usuarioId);
	}

	public List<Corrida> buscarCorridasPorMotorista(Long motoristaId) {
		return corridaRepository.findByMotoristaId(motoristaId);
	}

	public List<Corrida> listarCorridas() {
		return corridaRepository.findAll();
	}

	public Optional<Corrida> atualizarCorrida(Corrida corrida) {
		return corridaRepository.findById(corrida.getId()).flatMap(corridaExistente -> {
			corridaExistente.setOrigem(corrida.getOrigem());
			corridaExistente.setDestino(corrida.getDestino());
			corridaExistente.setPreco(corrida.getPreco());
			corridaExistente.setVelocidadeMedia(corrida.getVelocidadeMedia());
			corridaExistente.setDistanciaKm(corrida.getDistanciaKm());

			String email = SecurityContextHolder.getContext().getAuthentication().getName();
			Usuario usuario = usuarioRepository.findByEmail(email)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
							"Usuário não encontrado"));

			corridaExistente.setUsuario(usuario);

			return Optional.of(corridaRepository.save(corridaExistente));
		});
	}

	public void deletarCorrida(Long id) {
		corridaRepository.deleteById(id);
	}

	public CalculoTempoCorridaDTO calcularTempoCorrida(Corrida corrida) {

		double tempoDeViagemHoras = corrida.getDistanciaKm() / corrida.getVelocidadeMedia();
		long tempoDeViagemMinutos = (long) (tempoDeViagemHoras * 60);

		String tempoDeViagemFormatado;

		if (tempoDeViagemMinutos < 60) {
			tempoDeViagemFormatado = tempoDeViagemMinutos + " minutos";
		} else {
			long horas = tempoDeViagemMinutos / 60;
			long minutosRestantes = tempoDeViagemMinutos % 60;

			if (minutosRestantes == 0) {
				tempoDeViagemFormatado = horas + (horas == 1 ? " hora" : " horas");
			} else {
				tempoDeViagemFormatado = horas + (horas == 1 ? " hora" : " horas") + " e "
						+ minutosRestantes + " minutos";
			}
		}

		LocalDateTime tempoPrevistoChegada = corrida.getHorario().plusMinutes(tempoDeViagemMinutos);

		return new CalculoTempoCorridaDTO(corrida.getOrigem(), corrida.getDestino(),
				tempoDeViagemFormatado, tempoPrevistoChegada);
	}
}
