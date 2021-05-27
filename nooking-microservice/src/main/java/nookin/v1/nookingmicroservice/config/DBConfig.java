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

            // Categorias
            Categoria categoriaIrlandes = new Categoria(20,18,24,TipoCategoriaRestaurante.IRLANDES,"https://www.irlanda.net/wp-content/uploads/sites/10/pub-irlanda.jpg","Un Irish pub es un local publico en el que se sirven bebidas y comidas. El uso del termino 'bar' para un local de estas caracteristicas es mas comun en Irlanda que en el Reino Unido. En 1635 habia 1180 pubs licenciados en Dublin.* A comienzos del siglo XX los pubs irlandeses eran locales de venta de alcohol.");
            Categoria categoriaDiscoteca = new Categoria(18,24,06,TipoCategoriaRestaurante.DISCOTECA,"https://estaticos-cdn.elperiodico.com/clip/dcfa9ecb-b429-4658-9bf2-9461443d645b_alta-libre-aspect-ratio_default_0.jpg","Una discoteca, tambien conocida en Argentina, Paraguay, Uruguay y en el sur de Bolivia como boliche, en Mexico como antro y en los Estados Unidos como diskothek, tambien conocidas en otros paises como night club (club nocturno), boite, disco, etc; son lugares por lo general de pago o con invitacion, con horario preferentemente nocturno, donde los concurrentes pueden bailar, socializar o consumir bebidas alcoholicas y, en general, tienen el entretenimiento como objetivo. ");
            Categoria categoriaCopas = new Categoria(25,18,06,TipoCategoriaRestaurante.COPAS,"https://p4.wallpaperbetter.com/wallpaper/120/62/411/5bd0299a8cef9-wallpaper-preview.jpg", "Son lugares a los que la gente acude para desconectar, pasar el rato en buen ambiente y disfrutar en un entorno amable. Frente al bar de toda la vida, estos locales de copas presentan un ambiente más cool, asientos o butacas confortables y una atmósfera que invita a la relajación. Suelen contar con una variada oferta de bebidas, según sus características, especialmente en lo relativo a cerveza, destilados, vinos, cócteles y refrescos.");
            Categoria categoriaAzotea = new Categoria(30,17,23,TipoCategoriaRestaurante.AZOTEA,"https://i.pinimg.com/originals/3c/8c/9e/3c8c9e139d33ae32453741c476647043.jpg", "Una terraza o terraza bar es un espacio hostelero exterior (bien en patios o al aire libre). A menudo se establece como una prolongación externa de un negocio ya existente como puede ser un bar, un restaurante u hotel que se puede realizar a pie de calle bien sea en el espacio de una plaza, un jardín, un mirador con vistas, en el porche de un edificio, en una sala, o junto a otras terrazas en un bulevar.");


            //LOCALES
            //Local1
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
            Direccion dirBarcelo= new Direccion("C. de Barceló, 11, 28004 Madrid",40.4269,-3.6998,"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12148.735169352476!2d-3.699822!3d40.426929!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x7a731def889d4532!2sBarcel%C3%B3%20Theatre!5e0!3m2!1sen!2ses!4v1622121552862!5m2!1sen!2ses");
            Local teatroBarcelo = new Local("Teatro Barcelo",dirBarcelo,"https://teatrobarcelo.com/en/","913450392",500);
            teatroBarcelo.setCategoria(categoriaDiscoteca);
            //teatroBarcelo.setPropietario(senorIrlandes);
            teatroBarcelo.setUrlImagenLocal("https://www.clubbookers.com/wp-content/uploads/2017/05/teatro-barcelo-madrid-featured.jpg");

            //Local 4
            Direccion dirCirculoBellasArtes = new Direccion("Calle de Alcalá, 42, 28014 Madrid",40.418,-3.697,"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12150.292913824718!2d-3.6965333!3d40.4183042!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xa921f67f134d1c1a!2sC%C3%ADrculo%20de%20Bellas%20Artes!5e0!3m2!1ses!2ses!4v1622148590815!5m2!1ses!2ses");
            Local CirculoBellasArtes = new Local("Círculo de Bellas Artes",dirCirculoBellasArtes,"https://www.circulobellasartes.com/azotea/","915 30 17 61",80);
            CirculoBellasArtes.setCategoria(categoriaAzotea);
            //irishRover.setPropietario(senorIrlandes);
            CirculoBellasArtes.setUrlImagenLocal("https://www.circulobellasartes.com/blog/wp-content/uploads/2020/03/Azotea-Minerva-Torre%C3%B3n.jpg");

            //Local 5
            Direccion dirLaFelicidad = new Direccion(" Av. de la Reina Victoria, 19, 28003 Madrid",40.44769622668854, -3.70699523862708,"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12145.136664730546!2d-3.7071669!3d40.4468471!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xaf46bd37a6d896a4!2sBar%20La%20Felicidad!5e0!3m2!1ses!2ses!4v1622149041817!5m2!1ses!2ses");
            Local laFelicidad = new Local("La Felicidad",dirLaFelicidad,"https://barlafelicidad.com/","915 34 50 20",56);
            laFelicidad.setCategoria(categoriaCopas);
            //irishRover.setPropietario(senorIrlandes);
            laFelicidad.setUrlImagenLocal("https://www.larazon.es/resizer/Vi_r8Y9ZyXUG2FOGdNqvbAWBocs=/840x0/smart/filters:format(jpg)/cloudfront-eu-central-1.images.arcpublishing.com/larazon/YPGY537HQVC4ND34POESKRC2S4.jpg");

            //Local 6
            Direccion dirChapandaz = new Direccion("C. de Fernando el Católico, 77, 28015 Madrid",40.43464540950222, -3.7175756,"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12147.423873667354!2d-3.7175756!3d40.4341881!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x115da710986cacd1!2sEl%20Chapandaz!5e0!3m2!1ses!2ses!4v1622150350064!5m2!1ses!2ses");
            Local elChapandaz = new Local("El Chapandaz",dirChapandaz,"https://elchapandaz.com/","+915 49 29 68",107);
            elChapandaz.setCategoria(categoriaCopas);
            //irishRover.setPropietario(senorIrlandes);
            elChapandaz.setUrlImagenLocal("https://unbuendiaenmadrid.com/wp-content/uploads/2012/12/IMG_0118.jpg");

            //senorIrlandes.addLocales(teatroBarcelo);
            localesRepository.saveAll(List.of(teatroBarcelo,coventGarden,CirculoBellasArtes, laFelicidad, elChapandaz));

            //USUARIOS
            Usuario santi = new Usuario("Santiago","A1b2c3d4","642578958","santi@hotmail.com",18);
            Usuario nacho=new Usuario("nachoDivasson","Divasson","639874682","nacho@divasson.com",20);
            Usuario alex=new Usuario("alejandro","Gonzzalez","630960855","alex@gmail.com",30);
            

            //Valoraciones
            Valoracion valoracion = new Valoracion("Me encanta este sitio!",5,irishRover);
            irishRover.setValoraciones(List.of(valoracion));

            //Reservas
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

