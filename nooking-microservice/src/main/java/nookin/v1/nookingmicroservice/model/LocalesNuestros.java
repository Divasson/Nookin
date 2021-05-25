package nookin.v1.nookingmicroservice.model;

import lombok.Data;

@Data
public class LocalesNuestros extends Local{
    private String cuentaPayPal;
    private String cuentaBancaria;
    private Float saldo;
    private String email;
}
