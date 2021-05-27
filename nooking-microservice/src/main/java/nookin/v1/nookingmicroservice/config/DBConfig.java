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

    

    @Bean
    @Transactional
    CommandLineRunner commandLineRunner(LocalesRepository localesRepository,UsuarioRepository usuariosRepository,PropietariosRepository propietariosRepository,ValoracionesRepository valoracionesRepository,ReservasRepository reservasRepository){
        return args -> {

            //Propietarios
            Propietarios senorIrlandes = new Propietarios("Mr Rover","913886238","rover@irishRover.com",60);

            //LOCALES
            //Local1
            Categoria categoriaIrlandes = new Categoria(20,18,24,TipoCategoriaRestaurante.IRLANDES,"https://www.irlanda.net/wp-content/uploads/sites/10/pub-irlanda.jpg","Un Irish pub es un local publico en el que se sirven bebidas y comidas. El uso del termino 'bar' para un local de estas caracteristicas es mas comun en Irlanda que en el Reino Unido. En 1635 habia 1180 pubs licenciados en Dublin.* A comienzos del siglo XX los pubs irlandeses eran locales de venta de alcohol.");
            Direccion dirIrishRover = new Direccion("Av. de Brasil, 7, 28020 Madrid",40.4547,-3.6940,"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12143.7124923661!2d-3.6939592!3d40.4547278!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xac5dccb9e6db0dd5!2sThe%20Irish%20Rover!5e0!3m2!1sen!2ses!4v1622121253527!5m2!1sen!2ses");
            Local irishRover = new Local("Irish Rover",dirIrishRover,"https://www.theirishrover.com/","915974811",100);
            irishRover.setCategoria(categoriaIrlandes);
            //irishRover.setPropietario(senorIrlandes);
            irishRover.setUrlImagenLocal("https://media-cdn.tripadvisor.com/media/photo-s/0f/08/36/ff/the-garden.jpg");
            

            senorIrlandes.addLocales(irishRover);

            //Local 2
            
            Direccion dirCoventGarden = new Direccion("Calle del Dr. Fleming, 31, 28036 Madrid",40.4609,-3.6880,"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12142.587875978732!2d-3.688023!3d40.46095!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x4828644e3e4f6af!2sCovent%20Garden%20English%20Pub!5e0!3m2!1sen!2ses!4v1622121196852!5m2!1sen!2ses");
            Local coventGarden = new Local("Covent Garden",dirCoventGarden,"http://coventgarden.es/covent-garden/","913450392",100);
            coventGarden.setCategoria(categoriaIrlandes);
            coventGarden.setPropietario(senorIrlandes);
            coventGarden.setUrlImagenLocal("http://coventgarden.es/wp-content/uploads/2014/03/DSC_0698-e1455616274162.jpg");

            //senorIrlandes.addLocales(coventGarden);
            
            //Local 3
            Categoria categoriaDiscoteca = new Categoria(18,24,06,TipoCategoriaRestaurante.DISCOTECA,"https://estaticos-cdn.elperiodico.com/clip/dcfa9ecb-b429-4658-9bf2-9461443d645b_alta-libre-aspect-ratio_default_0.jpg","Una discoteca, tambien conocida en Argentina, Paraguay, Uruguay y en el sur de Bolivia como boliche, en Mexico como antro y en los Estados Unidos como diskothek, tambien conocidas en otros paises como night club (club nocturno), boite, disco, etc; son lugares por lo general de pago o con invitacion, con horario preferentemente nocturno, donde los concurrentes pueden bailar, socializar o consumir bebidas alcoholicas y, en general, tienen el entretenimiento como objetivo. ");
            Direccion dirBarcelo= new Direccion("C. de Barceló, 11, 28004 Madrid",40.4269,-3.6998,"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12148.735169352476!2d-3.699822!3d40.426929!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x7a731def889d4532!2sBarcel%C3%B3%20Theatre!5e0!3m2!1sen!2ses!4v1622121552862!5m2!1sen!2ses");
            Local teatroBarcelo = new Local("Teatro Barcelo",dirBarcelo,"https://teatrobarcelo.com/en/","913450392",500);
            teatroBarcelo.setCategoria(categoriaDiscoteca);
            //teatroBarcelo.setPropietario(senorIrlandes);
            teatroBarcelo.setUrlImagenLocal("https://www.clubbookers.com/wp-content/uploads/2017/05/teatro-barcelo-madrid-featured.jpg");
            
            //senorIrlandes.addLocales(teatroBarcelo);
            localesRepository.saveAll(List.of(teatroBarcelo,coventGarden));

            //USUARIOS
            Usuario santi = new Usuario("Santiago","A1b2c3d4","642578958","santi@hotmail.com",18);
            Usuario nacho=new Usuario("nachoDivasson","Divasson","639874682","nacho@divasson.com",20);
            Usuario alex=new Usuario("alejandro","Gonzzalez","630960855","alex@gmail.com",30);
            


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
            //localesRepository.saveAll(List.of(irishRover,teatroBarcelo,coventGarden));
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

