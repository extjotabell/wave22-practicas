package main.transacciones;

public interface Transaccion {

    boolean transaccionOK();
    boolean transaccionNO_OK();

    String getNombre();


}
