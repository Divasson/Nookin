package nookin.v1.nookingmicroservice.service.Impl;

import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import nookin.v1.nookingmicroservice.model.JwtSignupRequest;
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
    public Usuario getUsuarioEmail(String email) {
        return usuarioRepository.getUsuarioByEmail(email);
    }

    @Override
    public Optional<Usuario> getUsuarioId(Long id) {
        // TODO Auto-generated method stub
        return usuarioRepository.findById(id);
    }

    /* @Override
    public ResponseEntity<Usuario> anadirUsuario(Usuario user) {
        // TODO Auto-generated method stub
        if(Objects.nonNull(usuarioRepository.getUsuarioByNombre(user.getNombre()))){
            return ResponseEntity.badRequest().body(null);
        }
        user.setContrasena(passwordEncoder.encode(user.getContrasena()));
        usuarioRepository.save(user);
        return ResponseEntity.ok().body(user);

    } */

    @Override
    public boolean isUsuarioEmail(String email) {
        // TODO Auto-generated method stub
        Iterator<Usuario> it = usuarioRepository.findAll().iterator();
        while(it.hasNext()){
            Usuario us = it.next();
            if(us.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    @Override
    public ResponseEntity<Usuario> anadirUsuario(JwtSignupRequest user) {
        if(user.getPassword().equals(user.getPassword2()) && !isUsuarioEmail(user.getEmail())){
            Usuario us = new Usuario(user.getName(), passwordEncoder.encode(user.getPassword()), user.getTelephone(), user.getEmail(), user.getAge());
            usuarioRepository.save(us);
            return ResponseEntity.ok().body(us);
        }
        

        return ResponseEntity.badRequest().body(null);
    }
    
}
