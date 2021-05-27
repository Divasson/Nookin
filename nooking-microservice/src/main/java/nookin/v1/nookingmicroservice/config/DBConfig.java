package nookin.v1.nookingmicroservice.config;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.val;
import nookin.v1.nookingmicroservice.model.Categoria;
import nookin.v1.nookingmicroservice.model.Direccion;
import nookin.v1.nookingmicroservice.model.EstadoReserva;
import nookin.v1.nookingmicroservice.model.Local;
import nookin.v1.nookingmicroservice.model.Propietarios;
import nookin.v1.nookingmicroservice.model.Reserva;
import nookin.v1.nookingmicroservice.model.TipoCategoriaRestaurante;
import nookin.v1.nookingmicroservice.model.Usuario;
import nookin.v1.nookingmicroservice.model.Valoracion;
import nookin.v1.nookingmicroservice.repository.LocalesRepository;
import nookin.v1.nookingmicroservice.repository.PropietariosRepository;
import nookin.v1.nookingmicroservice.repository.ReservasRepository;
import nookin.v1.nookingmicroservice.repository.UsuarioRepository;
import nookin.v1.nookingmicroservice.repository.ValoracionesRepository;

@Configuration
public class DBConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    @Transactional
    CommandLineRunner commandLineRunner(LocalesRepository localesRepository,UsuarioRepository usuariosRepository,PropietariosRepository propietariosRepository,ValoracionesRepository valoracionesRepository,ReservasRepository reservasRepository){
        return args -> {

            //Propietarios
            Propietarios senorIrlandes = new Propietarios("Mr Rover","913886238","rover@irishRover.com",60);

            //LOCALES
            Categoria categoriaIrishRover = new Categoria(20,18,24,TipoCategoriaRestaurante.IRLANDES);
            Direccion dirIrishRover = new Direccion("Av. de Brasil, 7, 28020 Madrid",40.4547,-3.6940,"https://g.page/TheIrishRoverMadrid?share");
            Local irishRover = new Local("Irish Rover",dirIrishRover,"https://www.theirishrover.com/","915974811",100);
            irishRover.setCategoria(categoriaIrishRover);
            irishRover.setPropietario(senorIrlandes);
            irishRover.setUrlImagenLocal("https://media-cdn.tripadvisor.com/media/photo-s/0f/08/36/ff/the-garden.jpg");
            

            senorIrlandes.addLocales(irishRover);
            
            
            

            //USUARIOS
            Usuario santi = new Usuario("Santiago","A1b2c3d4","642578958","santi@hotmail.com",18);
            Usuario nacho=new Usuario("nachoDivasson","Divasson","639874682","nacho@divasson.com",20);
            Usuario alex=new Usuario("alejandro","Gonzzalez","630960855","alex@gmail.com",30);
            santi.setContrasena(passwordEncoder.encode(santi.getContrasena()));
            nacho.setContrasena(passwordEncoder.encode(nacho.getContrasena()));
            alex.setContrasena(passwordEncoder.encode(alex.getContrasena()));


            //Valoraciones
            Valoracion valoracion = new Valoracion("Me encanta este sitio!",5,irishRover);
            irishRover.setValoraciones(List.of(valoracion));
            

            Reserva reserva = new Reserva(Date.from(LocalDate.of( 2021 , 05 , 30 ).atStartOfDay(ZoneId.systemDefault()).toInstant()),List.of(santi,nacho,alex),irishRover,3,EstadoReserva.ACTIVA);
            irishRover.setReservas(List.of(reserva));
            santi.setReservas(List.of(reserva));
            nacho.setReservas(List.of(reserva));
            alex.setReservas(List.of(reserva));
            

            //Guaradar valores


            //valoraciones
            valoracionesRepository.saveAll(List.of(valoracion));
            //locales
            localesRepository.saveAll(List.of(irishRover));
            //propietarios
            propietariosRepository.saveAll(List.of(senorIrlandes));
            //usuarios
            usuariosRepository.saveAll(List.of(nacho,alex,santi));
            

            //Reservas
            //irishRover = localesRepository.findById(irishRover.getId()).get();

            

            //reservas
            reservasRepository.saveAll(List.of(reserva));


        };
    }
}

