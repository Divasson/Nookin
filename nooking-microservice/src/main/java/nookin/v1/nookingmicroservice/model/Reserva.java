package nookin.v1.nookingmicroservice.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;



import lombok.Data;

@Data
@Entity(name = "RESERVAS")
public class Reserva {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Date fechaReserva;

    @NotNull
    @ManyToMany
    @JoinTable(name = "USUARIOS_RESERVA")
    private List<Usuario> usuariosReserva;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Local localReserva;

    @NotNull
    private Integer numPersonasReserva;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoReserva estadoReserva;
    
    @NotNull
    private String urlImagenLocal;
}
