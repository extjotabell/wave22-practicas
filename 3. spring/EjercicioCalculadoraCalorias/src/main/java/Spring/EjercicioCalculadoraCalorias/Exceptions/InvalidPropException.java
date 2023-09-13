package Spring.EjercicioCalculadoraCalorias.Exceptions;

public class InvalidPropException extends RuntimeException{
    public InvalidPropException(){}
    public InvalidPropException(String message)
    {
        super(message);
    }
}
