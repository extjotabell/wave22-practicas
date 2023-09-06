import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarRopa {
    private Map<Integer, List<Prenda>> guardarropas;
    private int contador;

    public GuardarRopa() {
        this.guardarropas = new HashMap<>();
        this.contador = 1;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        guardarropas.put(contador, listaDePrenda);
        return contador++;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> prendaObjeto : guardarropas.entrySet()) {
            Integer numeroIdentificador = prendaObjeto.getKey();
            List<Prenda> prendas = prendaObjeto.getValue();

            System.out.println("Número de identificador: " + numeroIdentificador);

            for (Prenda prenda : prendas) {
                System.out.println("Marca: " + prenda.getMarca() + ", Modelo: " + prenda.getModelo());
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return guardarropas.get(numero);
    }
}
