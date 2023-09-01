package main.transacciones;

public class ConsultaSaldo implements Transaccion{

    private String nombre = "ConsultaSaldo";

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
