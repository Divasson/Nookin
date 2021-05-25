package nookin.v1.nookingmicroservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nookin.v1.nookingmicroservice.model.Usuario;

@Service
public interface UsuariosService {
    public ResponseEntity<Usuario> getUsuarioNombre(String nombre);
    public ResponseEntity<Usuario> getUsuarioId(Long id);
    public ResponseEntity<Usuario> anadirUsuario(Usuario user);
}
