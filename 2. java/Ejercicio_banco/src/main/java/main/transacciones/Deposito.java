package main.transacciones;

public class Deposito implements Transaccion{
    private String nombre = "Deposito";
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
