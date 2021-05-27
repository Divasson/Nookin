package nookin.v1.nookingmicroservice.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;
import nookin.v1.nookingmicroservice.model.JwtRequest;
import nookin.v1.nookingmicroservice.model.JwtSignupRequest;
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
    public ResponseEntity<Usuario> getUsuarioEmail(@RequestParam String email){
        if(usuariosService.isUsuarioEmail(email)){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(usuariosService.getUsuarioEmail(email));
    }

    
    @GetMapping("usuarios/verUsuarioId")
    public ResponseEntity<Usuario> getUsuarioId(@RequestParam Long id){
        return null;
    }

    @PostMapping(
        path = "nuevosUsuarios/anadir",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> anadirUsuario(@Valid @RequestBody JwtSignupRequest user,BindingResult bindingResult){
        System.out.println(user);
/*         if(bindingResult.hasErrors()){
            System.out.println("Algo ha ido mal");
            return ResponseEntity.badRequest().body(null);
        } */
        return usuariosService.anadirUsuario(user);
    }

    @PostMapping(
        path = "comprobarUsuarios",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> anadirUsuario(@Valid @RequestBody JwtRequest user,BindingResult bindingResult){
        System.out.println(user);
/*         if(bindingResult.hasErrors()){
            System.out.println("Algo ha ido mal");
            return ResponseEntity.badRequest().body(null);
        } */
        return usuariosService.isUsuario(user);
    }
}
