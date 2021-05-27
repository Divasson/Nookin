package nookin.v1.nookingmicroservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "PROPIETARIOS")
public class Propietarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;

    
    @Pattern(regexp ="[\\d]{9}") //9 dígitos solo
    private String telefono;

    
    private String email;

    
    private Integer edad;

    @OneToMany(mappedBy = "propietario")
    private List<Local> locales = new ArrayList<>();

    public Propietarios(@NotNull String nombre, @NotNull @Pattern(regexp = "[\\d]{9}") String telefono,
            @NotNull @Pattern(regexp = "/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/g") String email,
            @Min(0) Integer edad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.edad = edad;
    }

    public void addLocales(Local local){

        this.locales.add(local);
        
        
    }

    
}
