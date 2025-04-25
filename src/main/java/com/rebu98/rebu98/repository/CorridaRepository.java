package com.rebu98.rebu98.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.rebu98.rebu98.model.Corrida;

@Repository
public interface CorridaRepository extends JpaRepository<Corrida, Long> {
	
	public List<Corrida> findByUsuario(Long usuarioId);

    public List<Corrida> findByMotorista(Long motoristaId);
}
