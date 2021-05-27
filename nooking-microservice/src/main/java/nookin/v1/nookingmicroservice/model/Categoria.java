package nookin.v1.nookingmicroservice.model;

import java.time.Period;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class Categoria {
    @Min(0)
    private Integer edadRecomendada;
    private Integer horaInicio;
    private Integer horaFinal; 
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoCategoriaRestaurante tipoCategoria;
    
    public Categoria(@Min(0) Integer edadRecomendada, Integer horaInicio, Integer horaFinal,
            @NotNull TipoCategoriaRestaurante tipoCategoria) {
        this.edadRecomendada = edadRecomendada;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.tipoCategoria = tipoCategoria;
    }

    
}
