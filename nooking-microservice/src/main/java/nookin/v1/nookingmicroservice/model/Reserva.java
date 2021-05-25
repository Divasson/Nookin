package nookin.v1.nookingmicroservice.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Reserva {
    //Atributos
    private Long id;
    private Date fechaReserva;
    private Usuario usuarioReserva;
    private List<Usuario> usuariosInvitados;
    private Local localReserva;
    private Integer numPersonasReserva;
    
}
