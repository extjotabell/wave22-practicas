package domain;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private List<Paquete> paquetes;

    public Localizador() {
        paquetes = new ArrayList<>();
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void addPaquete(Paquete paquete) {
        paquetes.add(paquete);
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "paquetes=" + paquetes +
                '}';
    }
}
