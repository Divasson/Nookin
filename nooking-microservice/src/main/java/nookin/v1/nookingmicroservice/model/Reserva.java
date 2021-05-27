package nookin.v1.nookingmicroservice.model;

import java.time.LocalDate;
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
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "RESERVAS")
public class Reserva {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private LocalDate fechaReserva;

    
    @ManyToMany
    @JoinTable(name = "USUARIOS_RESERVA")
    private List<Usuario> usuariosReserva;

    
    @ManyToOne(cascade = CascadeType.MERGE)
    private Local localReserva;

    
    private Integer numPersonasReserva;

    
    @Enumerated(EnumType.STRING)
    private EstadoReserva estadoReserva;
    


    public Reserva(@NotNull LocalDate fechaReserva, @NotNull List<Usuario> usuariosReserva, @NotNull Local localReserva,
            @NotNull Integer numPersonasReserva, @NotNull EstadoReserva estadoReserva) {
        this.fechaReserva = fechaReserva;
        this.usuariosReserva = usuariosReserva;
        this.localReserva = localReserva;
        this.numPersonasReserva = numPersonasReserva;
        this.estadoReserva = estadoReserva;

    }

    
}
