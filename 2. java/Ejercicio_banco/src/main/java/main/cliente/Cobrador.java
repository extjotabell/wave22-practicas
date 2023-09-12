package main.cliente;

import main.transacciones.ConsultaSaldo;
import main.transacciones.Retiro;
import main.transacciones.Transaccion;

import java.util.ArrayList;
import java.util.List;

public class Cobrador extends Cliente{

List<Transaccion> transValidas = new ArrayList<>();

    public Cobrador(String nombre, String cuenta, double saldo) {
        super(nombre, cuenta, saldo);
        transValidas.add(new Retiro());
        transValidas.add(new ConsultaSaldo());
    }

    @Override
    public String realizarTransaccion(Transaccion tr) {
        String mensaje = "La transaccion realizada por el cliente:"+nombre+" fue ";
        if (transValidas.contains(tr)){
            return tr.transaccionOK()?mensaje+"TRANSACCION_OK = true":"TRANSACCION_OK = false";
        }
        return tr.transaccionNO_OK()?mensaje+"TRANSACCION_NO_OK:true":"TRANSACCION_NO_OK:false";
    }
}