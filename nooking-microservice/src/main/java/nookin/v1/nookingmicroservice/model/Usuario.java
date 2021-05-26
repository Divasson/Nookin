package nookin.v1.nookingmicroservice.model;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("CLIENTES")
public class Usuario{
    
    @Id
    private Long id;
    @NotNull
    private String nombre;

    @NotNull
    private String contrasena;

    @NotNull
    @Pattern(regexp ="[\\d]{9}") //9 dígitos solo
    private String telefono;

    @NotNull
    @Pattern(regexp ="/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/g") //email validation
    private String email;

    @Min(0)
    private Integer edad;

    @Min((long) 0.0)
    private Float saldo;
    
    @MappedCollection(keyColumn = "CLIENTES",idColumn = "CLIENTES")
    private List<Local> localesPreferidos;

    @MappedCollection(keyColumn = "CLIENTES",idColumn = "CLIENTES")
    private List<Reserva> reservas;

    
}
