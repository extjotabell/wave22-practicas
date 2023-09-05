import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Repositorio {


    private List<Localizador> localizadores;

    public Repositorio() {
        this.localizadores = new ArrayList<>();
    }

    public void agregarLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }

    /*public List<Localizador> obtenerReservasCliente(String cliente) {
        return localizadores.stream()
                .filter(r -> r.getCliente().equals(cliente))
                .collect(Collectors.toList());
    }*/

}
