import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class GuardaRopa {
    Map<Integer, List<Prenda>> guardaRopas = new HashMap<>();
    int contador;

    public GuardaRopa() {
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){

        this.guardaRopas.put(contador, listaDePrenda);
        Integer lugarAsignado = contador;
        this.contador+=1;
        return lugarAsignado;

        /*
        for (Map.Entry<Integer, List<Prenda>> entry : this.guardaRopas.entrySet()) {
            if (entry.getValue() == listaDePrenda) {
                return entry.getKey();
            }
        }
        return 0;
         */

    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : guardaRopas.entrySet()) {
            Integer identificador = entry.getKey();
            List<Prenda> prendas = entry.getValue();

            System.out.println("Identificador: " + identificador);
            for (Prenda prenda : prendas) {
                System.out.println("Marca: " + prenda.getMarca() + ", Modelo: " + prenda.getModelo());
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return this.guardaRopas.get(numero);
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "guardaRopas=" + guardaRopas +
                ", contador=" + contador +
                '}';
    }
}
