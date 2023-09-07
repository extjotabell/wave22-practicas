package Spring.Covid19.Interfaces;

import Spring.Covid19.Domain.Sintoma;

import java.util.List;

public interface ISintoma {
    List<Sintoma> obtenerSintomas();
    Sintoma obtenerSintomasPorNombre(String nombre);
    List<Sintoma> sintomaPorGravedad(String gravedad);
}
