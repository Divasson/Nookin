package nookin.v1.nookingmicroservice.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Valoracion {
    private String textoValoracion;

    @NotNull
    @Size(max = 5,min = 0)
    private Integer puntuacion;
}
