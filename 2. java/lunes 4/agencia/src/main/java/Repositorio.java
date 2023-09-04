import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    private List<Localizador> localizadores;

    public Repositorio() {
    }

    public Repositorio(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public List<Localizador> obtenerReservaCliente(Cliente cliente) {

        List<Localizador> resultado = new ArrayList<>();

        for (Localizador localizador : localizadores){
            if (localizador.getDatosCliente().getDni().equals(cliente.getDni())) {
                resultado.add(localizador);
            }
        }

        return resultado;
    }
}
