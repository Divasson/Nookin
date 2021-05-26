package nookin.v1.nookingmicroservice.model;

import lombok.Data;

@Data
public class Direccion {
    private String direccion;
    private Double latitud;
    private Double longitud;
}
