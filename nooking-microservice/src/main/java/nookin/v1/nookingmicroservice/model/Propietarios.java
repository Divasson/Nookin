package nookin.v1.nookingmicroservice.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Propietarios {
    
    @Id
    private Long id;
    @NotNull
    private String nombre;

    @NotNull
    @Pattern(regexp ="[\\d]{9}") //9 dígitos solo
    private String telefono;

    @NotNull
    @Pattern(regexp ="/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/g") //email validation
    private String email;

    private List<Local> locales;
}
