package nookin.v1.nookingmicroservice.controller;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
import nookin.v1.nookingmicroservice.model.Categoria;
import nookin.v1.nookingmicroservice.model.EstadoReserva;
import nookin.v1.nookingmicroservice.model.Local;
import nookin.v1.nookingmicroservice.model.Reserva;
import nookin.v1.nookingmicroservice.model.ReservaRequest;
import nookin.v1.nookingmicroservice.model.Usuario;
import nookin.v1.nookingmicroservice.service.LocalesService;
import nookin.v1.nookingmicroservice.service.UsuariosService;

import org.springframework.http.MediaType;

@Slf4j
@RestController
@RequestMapping(
        path = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE )
public class LocalesController {
    
    @Autowired
    private LocalesService localesService;

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private UsuariosController usuariosController;

    @GetMapping("/locales/verTodos")
    public ResponseEntity<List<Local>> getTodosLocales(){
        return ResponseEntity.ok().body(localesService.getTodosLocales());
    }

    @GetMapping("/locales/ver3Primeros")
    public ResponseEntity<List<Local>> get3Primeros(){
        return ResponseEntity.ok().body(localesService.get3Primeros());
    }

    @PostMapping(path = "/reservas",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reserva> hacerReserva(@RequestBody ReservaRequest reservaRequest){
        System.out.println(reservaRequest);
        

        return localesService.anadirReserva(reservaRequest);
    }

    @GetMapping("/locales")
    public ResponseEntity<Local> getLocal(@RequestParam Long id){
        return localesService.getLocalId(id);
    }

    @GetMapping("/locales/byCat")
    public ResponseEntity<List<Local>> getLocalesByCategoria(@RequestParam String cat){
        return ResponseEntity.ok().body(localesService.getLocalesByCat(cat));
    }

    @GetMapping("/locales/getCategorias")
    public ResponseEntity<List<Categoria>> getCategorias(){
        return ResponseEntity.ok().body(localesService.getCategorias());
    }

    @PostMapping(
        path = "/locales/anadirReserva",
        consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> anadirReserva(@RequestParam Long id,@Valid @RequestBody Reserva reserva){
        return null;
    }
    
}
