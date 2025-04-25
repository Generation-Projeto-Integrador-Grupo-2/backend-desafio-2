package com.rebu98.rebu98.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rebu98.rebu98.model.Motorista;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

}
