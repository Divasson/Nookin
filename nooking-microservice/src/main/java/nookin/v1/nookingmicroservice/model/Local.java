package nookin.v1.nookingmicroservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Embedded.OnEmpty;

import lombok.Data;

@Data
@Table("LOCALES")
public class Local {

    //Atributos
    @Id
    private Long id;
    private String nombre;
    @Embedded(onEmpty = OnEmpty.USE_EMPTY)
    private Direccion direccion;
    private String paginaWeb;
    private String telefono;
    private Integer aforo;
    private List<Valoracion> valoraciones;
    private List<Categoria> categorias;
    private List<Reserva> reservas;
}
