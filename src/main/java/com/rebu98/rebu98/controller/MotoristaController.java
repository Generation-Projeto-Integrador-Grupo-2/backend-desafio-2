package com.rebu98.rebu98.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rebu98.rebu98.model.Motorista;
import com.rebu98.rebu98.service.MotoristaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/motorista")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MotoristaController {

	@Autowired
	private MotoristaService motoristaService;

	@GetMapping
	public ResponseEntity<List<Motorista>> getAll() {
		return ResponseEntity.ok(motoristaService.listarMotoristas());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Motorista> getById(@PathVariable Long id) {
		return motoristaService.buscarPorId(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/cnh/{cnh}")
	public ResponseEntity<Motorista> getByCnh(@PathVariable String cnh) {
		return motoristaService.buscarPorCnh(cnh).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/modeloCarro/{modeloCarro}")
	public ResponseEntity<List<Motorista>> getByModeloCarro(@PathVariable String modeloCarro) {
		return motoristaService.buscarPorModeloCarro(modeloCarro)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/placa/{placa}")
	public ResponseEntity<Motorista> getByPlaca(@PathVariable String placa) {
		return motoristaService.buscarPorPlaca(placa).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Motorista> post(@Valid @RequestBody Motorista motorista) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(motoristaService.cadastrarMotorista(motorista));
	}

	@PreAuthorize("hasRole('MOTORISTA')")
	@PutMapping("/atualizar")
	public ResponseEntity<Motorista> put(@Valid @RequestBody Motorista motorista) {
		return motoristaService.atualizarMotorista(motorista)
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PreAuthorize("hasRole('MOTORISTA')")
	public void deletarMotorista(Long id) {
		motoristaService.delete(id);
	}
}
