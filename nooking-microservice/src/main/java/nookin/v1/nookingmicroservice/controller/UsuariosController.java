package nookin.v1.nookingmicroservice.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;
import nookin.v1.nookingmicroservice.model.Local;
import nookin.v1.nookingmicroservice.model.Reserva;
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

    @PostMapping(
        path = "nuevosUsuarios/anadir",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> anadirUsuario(@Valid @RequestBody Usuario user,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(null);
        }
        return usuariosService.anadirUsuario(user);
    }
}
