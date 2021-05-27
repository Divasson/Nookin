package nookin.v1.nookingmicroservice.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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


}
