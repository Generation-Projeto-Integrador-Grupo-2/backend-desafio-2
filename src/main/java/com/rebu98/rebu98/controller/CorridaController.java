package com.rebu98.rebu98.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rebu98.rebu98.model.Corrida;
import com.rebu98.rebu98.service.CorridaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/corridas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CorridaController {

	@Autowired
	private CorridaService corridaService;

	@GetMapping
	public ResponseEntity<List<Corrida>> getAll() {
		return ResponseEntity.ok(corridaService.listarCorridas());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Corrida> getById(@PathVariable Long id) {
		return corridaService.buscarPorId(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/usuario/{usuarioid}")
	public ResponseEntity<List<Corrida>> buscarCorridasPorUsuario(@PathVariable Long usuarioId) {
		return ResponseEntity.ok(corridaService.buscarCorridasPorUsuario(usuarioId));
	}

	@GetMapping("/motorista/{motoristaid}")
	public ResponseEntity<List<Corrida>> buscarCorridasPorMotorista(
			@PathVariable Long motoristaId) {
		return ResponseEntity.ok(corridaService.buscarCorridasPorMotorista(motoristaId));
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Corrida> post(@Valid @RequestBody Corrida corrida) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(corridaService.cadastrarCorrida(corrida));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Corrida> put(@Valid @RequestBody Corrida corrida) {
		return corridaService.atualizarCorrida(corrida)
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		corridaService.deletarCorrida(id);
	}

}
