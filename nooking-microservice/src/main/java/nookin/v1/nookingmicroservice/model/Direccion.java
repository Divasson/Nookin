package nookin.v1.nookingmicroservice.model;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class Direccion {
    private String direccion;
    private Double latitud;
    private Double longitud;
    private String googleMapsLink;
    

    public Direccion(String direccion, Double latitud, Double longitud, String googleMapsLink) {
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.googleMapsLink = googleMapsLink;
    }
}
