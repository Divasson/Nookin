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

import org.springframework.http.MediaType;

@Slf4j
@RestController
@RequestMapping(
        path = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE )
public class LocalesController {
    

    @GetMapping("/locales/verTodos")
    public ResponseEntity<List<Local>> getTodosLocales(){
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/locales/verLocal")
    public ResponseEntity<Local> getLocal(@RequestParam Long id){
        return ResponseEntity.ok().body(null);
    }

    @PostMapping(
        path = "/locales/anadirReserva",
        consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> anadirReserva(@RequestParam Long id,@Valid @RequestBody Reserva reserva){
        return null;
    }
}