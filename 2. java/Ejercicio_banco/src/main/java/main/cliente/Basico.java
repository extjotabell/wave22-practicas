package main.cliente;

import main.transacciones.ConsultaSaldo;
import main.transacciones.PagoServicios;
import main.transacciones.Retiro;
import main.transacciones.Transaccion;

import java.util.ArrayList;
import java.util.List;

public class Basico extends Cliente{
    List<Transaccion> transValidas = new ArrayList<>();

    public Basico(String nombre, String cuenta, double saldo) {
        super(nombre,cuenta,saldo);
        transValidas.add(new Retiro());
        transValidas.add(new ConsultaSaldo());
        transValidas.add(new PagoServicios());
    }

    @Override
    public String realizarTransaccion(Transaccion tr) {
        String mensaje = "La transaccion realizada por el cliente:" + nombre + " fue ";

        for (Transaccion t : transValidas) {
            if (t.getNombre() == tr.getNombre()) {
                return tr.transaccionOK() ? mensaje + "TRANSACCION_OK = true" : "TRANSACCION_OK = false";
            }
        }
        return tr.transaccionNO_OK() ? mensaje + "TRANSACCION_NO_OK:true" : "TRANSACCION_NO_OK:false";

    }
}
