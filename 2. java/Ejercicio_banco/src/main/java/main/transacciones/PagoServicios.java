package main.transacciones;

public class PagoServicios implements Transaccion{
    private String nombre = "Pago de Servicios";
    public String getNombre() {
        return nombre;
    }
    @Override
    public boolean transaccionOK() {
        return true;
    }

    @Override
    public boolean transaccionNO_OK() {
        return true;
    }
}
