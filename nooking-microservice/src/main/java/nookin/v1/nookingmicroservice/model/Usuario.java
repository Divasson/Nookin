package nookin.v1.nookingmicroservice.model;

import java.util.List;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import lombok.Data;

@Data
@Entity(name = "USUARIOS")
public class Usuario{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String contrasena;

    private String telefono;

    private String email;

    private Integer edad;

    private Float saldo;

    //private List<Local> localesPreferidos;

    @ManyToMany(mappedBy = "usuariosReserva")
    private List<Reserva> reservas;

    
}
