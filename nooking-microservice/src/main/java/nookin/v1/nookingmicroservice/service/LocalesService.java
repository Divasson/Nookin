package nookin.v1.nookingmicroservice.service;


import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nookin.v1.nookingmicroservice.model.Local;

@Service
public interface LocalesService {
    
    public ResponseEntity<Local> getLocalId(Long id);

    public List<Local> getTodosLocales();

    public List<Local> getTodosLocalesConSitio(Integer horaInicio,Integer horaFin,Date dia);
}
