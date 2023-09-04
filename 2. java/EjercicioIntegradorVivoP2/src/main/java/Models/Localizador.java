package Models;

import java.util.List;
import java.util.stream.Collectors;

public class Localizador {
    private Persona persona;
    private List<PaqueteTuristico> paqueteTuristico;

    public Localizador(Persona persona, List<PaqueteTuristico> paqueteTuristico) {
        this.persona = persona;
        this.paqueteTuristico = paqueteTuristico;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<PaqueteTuristico> getPaqueteTuristico() {
        return paqueteTuristico;
    }

    public void setPaqueteTuristico(List<PaqueteTuristico> paqueteTuristico) {
        this.paqueteTuristico = paqueteTuristico;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "persona=" + persona +
                ", paqueteTuristico=" + paqueteTuristico.stream().map(PaqueteTuristico::toString).collect(Collectors.toList()) +
                '}';
    }
}
