import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private  Map<Integer, List<Prenda>> ropero = new HashMap<>();
    private Integer contador = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        contador ++;
        ropero.put(contador, listaDePrendas);
        return contador;
    }

    public void mostrarPrendas(){
        ropero.forEach((key, value) -> System.out.println("Numero: " + key + ", prendas: " + value));
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return ropero.get(numero);
    }
}
