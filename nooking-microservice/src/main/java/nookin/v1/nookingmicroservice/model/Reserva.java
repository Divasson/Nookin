package nookin.v1.nookingmicroservice.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Reserva {
    //Atributos
    @Id
    private Long id;

    @NotNull
    private Date fechaReserva;

    @NotNull
    private Usuario usuarioReserva;
    private List<Usuario> usuariosInvitados;

    @NotNull
    private Local localReserva;

    @NotNull
    private Integer numPersonasReserva;
    
}
