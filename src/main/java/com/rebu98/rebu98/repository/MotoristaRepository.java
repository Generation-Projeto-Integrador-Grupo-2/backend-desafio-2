package com.rebu98.rebu98.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

import com.rebu98.rebu98.model.Motorista;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

	public Optional<Motorista> findAllByCnhContainingIgnoreCase(@Param("cnh") String cnh);

	public Optional<List<Motorista>> findAllByModeloCarroContainingIgnoreCase(@Param("modeloCarro") String modeloCarro);

	public Optional<Motorista> findAllByPlacaContainingIgnoreCase(@Param("placa") String placa);
}
