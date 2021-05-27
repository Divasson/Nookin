package nookin.v1.nookingmicroservice.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity(name = "LOCALES")
public class Local {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    @Embedded
    // @AttributeOverrides({
    // @AttributeOverride( name = "firstName", column = @Column(name =
    // "contact_first_name")),
    // @AttributeOverride( name = "lastName", column = @Column(name =
    // "contact_last_name")),
    // @AttributeOverride( name = "phone", column = @Column(name = "contact_phone"))
    // })
    private Direccion direccion;

    private String paginaWeb;

    private String telefono;

    @NotNull
    private Integer aforo;

    @OneToMany(mappedBy = "local")
    private List<Valoracion> valoraciones;

    @Embedded
    private Categoria categoria;

    @OneToMany(mappedBy = "localReserva")
    private List<Reserva> reservas;

    @ManyToOne(cascade = CascadeType.ALL)
    private Propietarios propietario;

    @NotNull
    private String urlImagenLocal;

    /*
     * public boolean isFull(Integer horaInicio, Integer horaFin,Date diaDate){
     * Integer suma = reservas.stream().filter(o ->
     * o.getFechaReserva().compareTo(diaDate)==0).filter(o ->
     * o.getEstadoReserva().equals(EstadoReserva.ACTIVA)).mapToInt(o ->
     * o.getNumPersonasReserva()).sum(); if(suma<aforo){ return false; } return
     * true;
     * 
     * }
     */

    

    public Local(@NotNull String nombre, @NotNull Direccion direccion, String paginaWeb, String telefono,
            @NotNull Integer aforo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.paginaWeb = paginaWeb;
        this.telefono = telefono;
        this.aforo = aforo;
    }

    public Local() {
    }
}
