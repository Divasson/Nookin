package nookin.v1.nookingmicroservice.model;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ReservaRequest {
    private List<String> usuariosReserva;
    private int numPersonasReserva;
    private String dia;
    private String mes;
    private String ano;
    private Long id_local;
}
