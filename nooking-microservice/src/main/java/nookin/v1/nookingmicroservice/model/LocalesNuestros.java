package nookin.v1.nookingmicroservice.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LocalesNuestros extends Local{
    private String cuentaPayPal;
    private String cuentaBancaria;
    private Float saldo;
    private String email;
    public LocalesNuestros(@NotNull String nombre, @NotNull Direccion direccion, String paginaWeb, String telefono,
            @NotNull Integer aforo, String cuentaPayPal, String cuentaBancaria, Float saldo, String email) {
        super(nombre, direccion, paginaWeb, telefono, aforo);
        this.cuentaPayPal = cuentaPayPal;
        this.cuentaBancaria = cuentaBancaria;
        this.saldo = saldo;
        this.email = email;
    }
}
