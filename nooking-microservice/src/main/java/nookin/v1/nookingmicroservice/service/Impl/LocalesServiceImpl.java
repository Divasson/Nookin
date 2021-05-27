package nookin.v1.nookingmicroservice.service.Impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nookin.v1.nookingmicroservice.model.Categoria;
import nookin.v1.nookingmicroservice.model.EstadoReserva;
import nookin.v1.nookingmicroservice.model.Local;
import nookin.v1.nookingmicroservice.model.Reserva;
import nookin.v1.nookingmicroservice.model.ReservaRequest;
import nookin.v1.nookingmicroservice.model.Usuario;
import nookin.v1.nookingmicroservice.repository.LocalesRepository;
import nookin.v1.nookingmicroservice.repository.ReservasRepository;
import nookin.v1.nookingmicroservice.repository.UsuarioRepository;
import nookin.v1.nookingmicroservice.service.LocalesService;
import nookin.v1.nookingmicroservice.service.UsuariosService;

@Service
public class LocalesServiceImpl implements LocalesService{

    @Autowired
    private LocalesRepository localesRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ReservasRepository reservasRepository;

    @Autowired
    private UsuariosService usuariosService;

    @Override
    public ResponseEntity<Local> getLocalId(Long id) {
        return ResponseEntity.ok().body(localesRepository.findById(id).get());
    }

    @Override
    public Local getLocalId2(Long id) {
        return localesRepository.findById(id).get();
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

    @Override
    public List<Local> get3Primeros() {
        List<Local> l= localesRepository.findAll();
        if(l.size()>2){
            List<Local> l2 = List.of(l.get(0),l.get(1),l.get(2));
            return l2;
        }else{
            return l;
        }
    }

    @Override
    @Transactional
    public ResponseEntity<Reserva> anadirReserva(ReservaRequest reservaRequest) {
        // TODO Auto-generated method stub
        
        Local local = localesRepository.findById(reservaRequest.getId_local()).get();
        System.out.println(local);
        List<Usuario> li= new ArrayList<Usuario>();
        

        
        Reserva reserva = new Reserva(Date.from(LocalDate.of( 2021 , 05 , 30 ).atStartOfDay(ZoneId.systemDefault()).toInstant()),li,local,reservaRequest.getNumPersonasReserva(), EstadoReserva.ACTIVA);
        List<Reserva> reservasDelLocal = local.getReservas();
        reservasDelLocal.add(reserva);
        local.setReservas(reservasDelLocal);



        reservasRepository.save(reserva);

        return ResponseEntity.ok().body(reserva);  
        
    }

    @Override
    public List<Local> getLocalesByCat(String cat) {
        return localesRepository.findAll().stream()
        .filter(o->o.getCategoria().getTipoCategoria().toString().equals(cat))
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
