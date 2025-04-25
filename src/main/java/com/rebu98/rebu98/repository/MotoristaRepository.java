package com.rebu98.rebu98.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.rebu98.rebu98.model.Motorista;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

	public List<Motorista> findAllByCnhContainingIgnoreCase(@Param("cnh") String cnh);

	public List<Motorista> findAllBymodeloCarroContainingIgnoreCase(
			@Param("modeloCarro") String modeloCarro);

	public List<Motorista> findAllByPlacaContainingIgnoreCase(@Param("placa") String placa);
}
