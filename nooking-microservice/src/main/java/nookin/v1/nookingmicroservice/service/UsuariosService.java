package nookin.v1.nookingmicroservice.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nookin.v1.nookingmicroservice.model.JwtRequest;
import nookin.v1.nookingmicroservice.model.JwtSignupRequest;
import nookin.v1.nookingmicroservice.model.Usuario;

@Service
public interface UsuariosService {
    public Usuario getUsuarioEmail(String email);
    public Optional<Usuario> getUsuarioId(Long id);
    public ResponseEntity<Usuario> anadirUsuario(JwtSignupRequest user);
    public boolean isUsuarioEmail(String email);
    public ResponseEntity<Usuario> isUsuario(JwtRequest user);
}
