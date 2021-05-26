package nookin.v1.nookingmicroservice.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nookin.v1.nookingmicroservice.model.Usuario;

@Service
public interface UsuariosService {
    public Usuario getUsuarioNombre(String nombre);
    public Optional<Usuario> getUsuarioId(Long id);
    public ResponseEntity<Usuario> anadirUsuario(Usuario user);
    public boolean isUsuarioNombre(String nombre);
}
