package com.rebu98.rebu98.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.rebu98.rebu98.dto.UsuarioRequestDTO;
import com.rebu98.rebu98.model.Usuario;
import com.rebu98.rebu98.model.UsuarioLogin;
import com.rebu98.rebu98.repository.UsuarioRepository;
import com.rebu98.rebu98.security.JwtService;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public Optional<Usuario> cadastrarUsuario(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já cadastrado!");
        }

        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return Optional.of(usuarioRepository.save(usuario));
    }

    public Optional<UsuarioLogin> autenticarUsuario(UsuarioLogin usuarioLogin) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioLogin.getEmail());

        if (usuario.isPresent()) {
            if (passwordEncoder.matches(usuarioLogin.getSenha(), usuario.get().getSenha())) {

                String token = jwtService.generateToken(usuario.get());

                usuarioLogin.setId(usuario.get().getId());
                usuarioLogin.setNome(usuario.get().getNome());
                usuarioLogin.setFoto(usuario.get().getFoto());
                usuarioLogin.setTipo(usuario.get().getTipo());
                usuarioLogin.setToken(token);

                return Optional.of(usuarioLogin);
            }
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário ou senha inválidos!");
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> atualizarUsuario(UsuarioRequestDTO usuarioRequest) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return usuarioRepository.findByEmail(email).map(usuario -> {
            usuario.setNome(usuarioRequest.nome());
            usuario.setFoto(usuarioRequest.foto());

            if (!usuario.getEmail().equals(usuarioRequest.email())) {
                usuario.setEmail(usuarioRequest.email());
            }

            if (!passwordEncoder.matches(usuarioRequest.senha(), usuario.getSenha())) {
                usuario.setSenha(passwordEncoder.encode(usuarioRequest.senha()));
            }

            return usuarioRepository.save(usuario);
        });
    }

    public void deletarUsuario(Long id) {
        Optional<Usuario> existente = usuarioRepository.findById(id);

        if (existente.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!");
        }

        usuarioRepository.deleteById(id);
    }
}
