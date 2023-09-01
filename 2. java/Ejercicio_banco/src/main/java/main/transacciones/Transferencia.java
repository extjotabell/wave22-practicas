package main.transacciones;

public class Transferencia implements Transaccion{
    private String nombre = "Transferencia";
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
