package com.rebu98.rebu98.Repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rebu98.rebu98.Model.UsuarioLogin;

@Repository
public interface UsuarioLoginRepository extends JpaRepository<UsuarioLogin, Long> {
    UsuarioLogin findByNome(String nome);
    UsuarioLogin findByToken(String token);
}