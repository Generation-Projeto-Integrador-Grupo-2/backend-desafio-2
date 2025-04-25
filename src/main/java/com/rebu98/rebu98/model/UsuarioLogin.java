package com.rebu98.rebu98.model;

import lombok.Data;

@Data
public class UsuarioLogin {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String foto;
    private String token;
    private TipoUsuario tipo;
}
