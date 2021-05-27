package nookin.v1.nookingmicroservice.controller;


import java.util.List;

import javax.validation.Valid;

import nookin.v1.nookingmicroservice.config.JwtTokenUtil;
import nookin.v1.nookingmicroservice.model.JwtResponse;
import nookin.v1.nookingmicroservice.model.JwtSignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import lombok.extern.slf4j.Slf4j;
import nookin.v1.nookingmicroservice.model.Usuario;
import nookin.v1.nookingmicroservice.service.UsuariosService;

import org.springframework.http.MediaType;

@Slf4j
@RestController
@RequestMapping(
        path = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE )
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService jwtInMemoryUserDetailsService;

    @GetMapping("usuarios/verUsuarioNombre")
    public ResponseEntity<Usuario> getUsuarioNombre(@RequestParam String nombre){
        if(usuariosService.isUsuarioNombre(nombre)){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(usuariosService.getUsuarioNombre(nombre));
    }

    
    @GetMapping("usuarios/verUsuarioId")
    public ResponseEntity<Usuario> getUsuarioId(@RequestParam Long id){
        return null;
    }

    @PostMapping(value = "/signup",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> signup(@Valid @RequestBody JwtSignupRequest authenticationRequest2) throws Exception {

        System.out.println("Hola");

        authenticationRequest2.setPassword(passwordEncoder.encode(authenticationRequest2.getPassword()));
        usuariosService.anadirUsuario(authenticationRequest2);

        final UserDetails userDetails = jwtInMemoryUserDetailsService
                .loadUserByUsername(authenticationRequest2.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok().body(new JwtResponse(token));
    }

}
