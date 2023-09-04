package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int id;
    private Map<Integer, List<Prenda>> guardarRopas;

    public GuardaRopa() {
        guardarRopas = new HashMap<>();
    }

    public Map<Integer, List<Prenda>> getIdentificador() {
        return guardarRopas;
    }

    private int generarNuevoId() {
        int ultimoId = guardarRopas.keySet().stream().mapToInt(Integer::intValue).max().orElse(0);
        this.id = ultimoId + 1;
        return this.id;
    }

    public int getId() {
        return id;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        Integer nuevoId = generarNuevoId();
        guardarRopas.put(nuevoId, listaDePrendas);
         return nuevoId;
    }

    public void mostrarPrendas() {
        for (Integer identificador : guardarRopas.keySet()) {
            String key = identificador.toString();
            List<Prenda> value = guardarRopas.get(identificador);
            System.out.println(key + " " + value);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> prendasGuardadas = new ArrayList<>();
        for (Integer identificador : guardarRopas.keySet()) {
            String key = identificador.toString();
            if(key.equals(numero.toString())) {
                prendasGuardadas = guardarRopas.get(identificador);
                return prendasGuardadas;
            }
        }
        return null;
    }
}

