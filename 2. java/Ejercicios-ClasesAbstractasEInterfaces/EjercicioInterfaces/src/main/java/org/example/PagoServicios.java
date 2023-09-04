package org.example;

public class PagoServicios implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Servicio pagado existosamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No tiene permisos para realizar la accion");
    }
}
