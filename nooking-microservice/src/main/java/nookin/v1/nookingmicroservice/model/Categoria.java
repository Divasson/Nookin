package nookin.v1.nookingmicroservice.model;

import java.time.Period;
import java.util.List;

import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class Categoria {
    @Min(0)
    private Integer edadRecomendada;
    private Integer horaInicio;
    private Integer horaFinal; 
    private List<TipoCategoriaRestaurante> categorias;
}
