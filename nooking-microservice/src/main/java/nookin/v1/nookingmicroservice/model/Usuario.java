package nookin.v1.nookingmicroservice.model;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


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

@NoArgsConstructor
@Data
@Entity(name = "USUARIOS")
public class Usuario{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nombre;

    @NotNull
    private String contrasena;

    @NotNull
    @Pattern(regexp ="[\\d]{9}") //9 dígitos solo
    private String telefono;

    @NotNull
    //@Pattern(regexp ="/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/g",message = "El email no es valido") //email validation
    //@Pattern(regexp = "^\\S+@\\S+\\.\\S$",message = "El email no es valido")
    private String email;

    @Min(0)
    private Integer edad;

    @Min((long) 0.0)
    private Float saldo;
    
    
    //private List<Local> localesPreferidos;

    @ManyToMany(mappedBy = "usuariosReserva")
    private List<Reserva> reservas;


    public Usuario(@NotNull String nombre, @NotNull String contrasena,
            @NotNull @Pattern(regexp = "[\\d]{9}") String telefono,
            @NotNull @Pattern(regexp = "/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/g") String email,
            @Min(0) Integer edad) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.email = email;
        this.edad = edad;
    }

    
    
}
