package nookin.v1.nookingmicroservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity(name = "VALORACIONES")
public class Valoracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String textoValoracion;

    @NotNull
    @Size(max = 5,min = 0)
    private Integer puntuacion;

    @ManyToOne(cascade = CascadeType.ALL)
    private Local local;
}
