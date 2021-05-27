package nookin.v1.nookingmicroservice.model;

import java.time.Period;
import java.util.List;

import javax.persistence.Column;
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
    
    private Integer edadRecomendada;
    private Integer horaInicio;
    private Integer horaFinal; 
    
    @Enumerated(EnumType.STRING)
    private TipoCategoriaRestaurante tipoCategoria;

    private String imagenCategoria;
    @Column(length=1512)
    private String descripcion;

    public Categoria(@Min(0) Integer edadRecomendada, Integer horaInicio, Integer horaFinal,
            @NotNull TipoCategoriaRestaurante tipoCategoria,String imagenCategoria,String descripcion) {
        this.edadRecomendada = edadRecomendada;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.tipoCategoria = tipoCategoria;
        this.imagenCategoria = imagenCategoria;
        this.descripcion = descripcion;
    }

    
}
