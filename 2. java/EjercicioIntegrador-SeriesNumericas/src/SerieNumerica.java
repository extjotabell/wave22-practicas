public abstract class SerieNumerica<T extends Number> {

    // Método para obtener el valor siguiente en la serie
    public abstract T obtenerSiguiente();

    // Método para reiniciar la serie al valor inicial
    public abstract void reiniciarSerie();

    // Método para establecer un nuevo valor inicial
    public abstract void establecerValorInicial(T nuevoValorInicial);

}


