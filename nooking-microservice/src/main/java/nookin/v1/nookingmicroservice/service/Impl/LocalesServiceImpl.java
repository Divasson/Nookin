package nookin.v1.nookingmicroservice.service.Impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nookin.v1.nookingmicroservice.model.Categoria;
import nookin.v1.nookingmicroservice.model.Local;
import nookin.v1.nookingmicroservice.repository.LocalesRepository;
import nookin.v1.nookingmicroservice.service.LocalesService;

@Service
public class LocalesServiceImpl implements LocalesService{

    @Autowired
    private LocalesRepository localesRepository;

    @Override
    public ResponseEntity<Local> getLocalId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Local> getTodosLocales() {
        return localesRepository.findAll();
    }

    @Override
    public List<Categoria> getCategorias() {
        return localesRepository
            .findAll()
            .stream()
            .map(o->o.getCategoria())
            .distinct()
            .collect(Collectors.toList());
    }

    /* @Override
    public List<Local> getTodosLocalesConSitio(Integer horaInicio, Integer horaFin,Date dia) {
        Iterator it =  localesRepository.findAll().iterator();
        List<Local> listaDevolver = null;
        while(it.hasNext()){
            Local l = (Local) it.next();
            if(l.isFull(horaInicio,horaFin,dia)){
                listaDevolver.add(l);
            }
        }
        return listaDevolver;
    } */
    
}
