package nookin.v1.nookingmicroservice.service.Impl;

import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;

import nookin.v1.nookingmicroservice.model.JwtSignupRequest;
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
    public void anadirUsuario(JwtSignupRequest user) {
        // TODO Auto-generated method stub
        usuarioRepository.addUsuario(user.getName(), user.getPassword(), user.getTelephone(), user.getEmail(), user.getAge());
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
