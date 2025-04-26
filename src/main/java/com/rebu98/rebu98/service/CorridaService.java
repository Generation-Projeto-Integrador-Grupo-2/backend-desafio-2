package com.rebu98.rebu98.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.rebu98.rebu98.dto.CalculoTempoCorridaDTO;
import com.rebu98.rebu98.model.Corrida;
import com.rebu98.rebu98.repository.CorridaRepository;

@Service
public class CorridaService {

	@Autowired
	private CorridaRepository corridaRepository;

	public Corrida cadastrarCorrida(Corrida corrida) {
		return corridaRepository.save(corrida);
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
		Optional<Corrida> corridaExistente = corridaRepository.findById(corrida.getId());
		if (corridaExistente.isPresent()) {
			Corrida novaCorrida = corridaExistente.get();
			novaCorrida.setOrigem(corrida.getOrigem());
			novaCorrida.setDestino(corrida.getDestino());
			novaCorrida.setPreco(corrida.getPreco());
			novaCorrida.setVelocidadeMedia(corrida.getVelocidadeMedia());
			novaCorrida.setDistanciaKm(corrida.getDistanciaKm());
			novaCorrida.setUsuario(corrida.getUsuario());
			novaCorrida.setMotorista(corrida.getMotorista());

			return Optional.of(corridaRepository.save(novaCorrida));
		}

		return Optional.empty();
	}

	public void deletarCorrida(Long id) {
		corridaRepository.deleteById(id);
	}

	public CalculoTempoCorridaDTO calcularTempoCorrida(Corrida corrida) {

		double tempoDeViagemHoras = corrida.getDistanciaKm() / corrida.getVelocidadeMedia();

		long tempoDeViagemMinutos = (long) (tempoDeViagemHoras * 60);

		LocalDateTime tempoPrevistoChegada = corrida.getHorario().plusMinutes(tempoDeViagemMinutos);

		return new CalculoTempoCorridaDTO(corrida.getOrigem(), corrida.getDestino(),
				tempoDeViagemHoras, tempoPrevistoChegada);
	}
}
