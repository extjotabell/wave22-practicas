package entity;

public abstract class EstadoOperacion {
    protected void transaccionOk() {
        System.out.println("Transaccion exitosa para el cliente: " + this);
    }

    protected void transaccionNoOk() {
        System.out.println("Transaccion fallida para el cliente: " + this +
                ". Operacion no habilitada.");
    }
}

