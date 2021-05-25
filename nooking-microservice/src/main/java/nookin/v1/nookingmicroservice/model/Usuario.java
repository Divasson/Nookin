package nookin.v1.nookingmicroservice.model;

import java.util.List;

import lombok.Data;

@Data
public class Usuario {
    //Atributos
    private Long id;
    private String nombre;
    private String telefono;
    private Long saldo;
    private List<Local> localesPreferidos;
    private String email;
    private EstadoReserva estadoReserva;
}
