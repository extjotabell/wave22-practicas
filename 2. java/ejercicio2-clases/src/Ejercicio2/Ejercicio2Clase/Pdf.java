package Ejercicio2.Ejercicio2Clase;

public class Pdf implements InterfazImprimibles{
    @Override
    public void imprimible(Documento documento) {
        System.out.println(documento);
    }
}
