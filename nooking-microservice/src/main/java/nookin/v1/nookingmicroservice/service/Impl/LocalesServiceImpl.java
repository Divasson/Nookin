package nookin.v1.nookingmicroservice.service.Impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nookin.v1.nookingmicroservice.model.Local;
import nookin.v1.nookingmicroservice.repository.LocalesRepository;
import nookin.v1.nookingmicroservice.service.LocalesService;

@Service
public class LocalesServiceImpl implements LocalesService{


    private LocalesRepository localesRepository;

    @Override
    public ResponseEntity<Local> getLocalId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Local> getTodosLocales() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Local> getTodosLocalesConSitio() {
        Iterator it =  localesRepository.findAll().iterator();
        List<Local> listaDevolver = null;
        while(it.hasNext()){
            Local l = (Local) it.next();
            if(l.isFull()){
                listaDevolver.add(l);
            }
        }
        return listaDevolver;
    }
    
}
