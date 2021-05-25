package nookin.v1.nookingmicroservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Local {

    //Atributos
    @Id
    private Long id;
    private String nombre;
    private Direccion direccion;
    private String paginaWeb;
    private String telefono;
    private Integer aforo;
    private List<Valoracion> valoraciones;
    private List<Categoria> categorias;
}
