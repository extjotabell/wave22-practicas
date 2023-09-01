package main.transacciones;

public class Retiro implements Transaccion{
    private String nombre = "Retiro";
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
