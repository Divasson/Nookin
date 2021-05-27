package nookin.v1.nookingmicroservice.service;

import java.util.Optional;

import nookin.v1.nookingmicroservice.model.JwtSignupRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nookin.v1.nookingmicroservice.model.Usuario;

@Service
public interface UsuariosService {
    Usuario getUsuarioNombre(String nombre);
    Optional<Usuario> getUsuarioId(Long id);
    void anadirUsuario(JwtSignupRequest user);
    boolean isUsuarioNombre(String nombre);
}
