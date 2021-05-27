package nookin.v1.nookingmicroservice.service;


import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nookin.v1.nookingmicroservice.model.Categoria;
import nookin.v1.nookingmicroservice.model.Local;
import nookin.v1.nookingmicroservice.model.Reserva;
import nookin.v1.nookingmicroservice.model.ReservaRequest;

@Service
public interface LocalesService {
    
    public ResponseEntity<Local> getLocalId(Long id);
    public Local getLocalId2(Long id);

    public List<Local> getTodosLocales();

    public List<Categoria> getCategorias();

    public List<Local> get3Primeros();

    public ResponseEntity<Reserva> anadirReserva(ReservaRequest reservaRequest);
    //public List<Local> getTodosLocalesConSitio(Integer horaInicio,Integer horaFin,Date dia);
    public List<Local> getLocalesByCat(String cat);
}
