package Spring.EjercicioCalculadoraCalorias.Exceptions;

public class PlatoNotFoundException extends RuntimeException {
    public PlatoNotFoundException(){}
    public PlatoNotFoundException(String message)
    {
        super(message);
    }
}
