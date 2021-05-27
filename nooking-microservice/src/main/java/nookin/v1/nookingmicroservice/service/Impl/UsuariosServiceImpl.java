package nookin.v1.nookingmicroservice.service.Impl;

import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import nookin.v1.nookingmicroservice.model.Usuario;
import nookin.v1.nookingmicroservice.repository.UsuarioRepository;
import nookin.v1.nookingmicroservice.service.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Usuario getUsuarioNombre(String nombre) {
        return usuarioRepository.getUsuarioByEmail(nombre);
    }

    @Override
    public Optional<Usuario> getUsuarioId(Long id) {
        // TODO Auto-generated method stub
        return usuarioRepository.findById(id);
    }

    @Override
    public ResponseEntity<Usuario> anadirUsuario(Usuario user) {
        // TODO Auto-generated method stub
        if(Objects.nonNull(usuarioRepository.getUsuarioByEmail(user.getNombre()))){
            return ResponseEntity.badRequest().body(null);
        }
        user.setContrasena(passwordEncoder.encode(user.getContrasena()));
        usuarioRepository.save(user);
        return ResponseEntity.ok().body(user);

    }

    @Override
    public boolean isUsuarioNombre(String nombre) {
        // TODO Auto-generated method stub
        Iterator<Usuario> it = usuarioRepository.findAll().iterator();
        while(it.hasNext()){
            Usuario us = it.next();
            if(us.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }
    
}
