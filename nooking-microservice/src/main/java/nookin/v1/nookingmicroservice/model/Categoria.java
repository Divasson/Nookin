package nookin.v1.nookingmicroservice.model;

import java.time.Period;
import java.util.List;

public class Categoria {
    private String tipo;
    private Integer edadRecomendada;
    private Integer horaInicio;
    private Integer horaFinal; 
    private List<TipoCategoriaRestaurante> categorias;
}
