package nookin.v1.nookingmicroservice.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Direccion {
    private String direccion;
    private Double latitud;
    private Double longitud;
}
