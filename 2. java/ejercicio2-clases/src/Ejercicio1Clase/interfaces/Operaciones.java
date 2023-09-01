package Ejercicio1Clase.interfaces;

public interface Operaciones {
    public abstract void transaccionOk(string tipo);
    public abstract void transaccionNoOk(string tipo);
}

public class Deposito implements Operaciones{
    public void Depositar(int)
}
public class Transferencia implements Operaciones{

}
public class RetiroEfectivo implements Operaciones{

}
public class ConsultaSaldo implements Operaciones{
    public void consultarSaldo(){
        System.out.println("Consultando el saldo...");
    }
}
public class PagoServicio implements Operaciones{

}