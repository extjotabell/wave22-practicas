public class Cliente {
    private String nombre;
    private int contadorLocalizadores;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.contadorLocalizadores = 0;
    }
    public void incrementarContadorLocalizadores() {
        this.contadorLocalizadores++;
    }

    public int getContadorLocalizadores() {
        return contadorLocalizadores;
    }

    public String getNombre() {
        return nombre;
    }
}
