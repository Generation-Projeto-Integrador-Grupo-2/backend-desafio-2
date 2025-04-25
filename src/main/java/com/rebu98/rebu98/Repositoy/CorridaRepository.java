package com.rebu98.rebu98.Repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.rebu98.rebu98.Model.Corrida;

@Repository
public interface CorridaRepository extends JpaRepository<Corrida, Long> {
    List<Corrida> findByUsuarioId(Long usuarioId);
    List<Corrida> findByMotoristaId(Long motoristaId);
}