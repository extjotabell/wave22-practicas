import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarRopa {

    Map<Integer, List<Prenda>> prendas;
    private int contador;

    public GuardarRopa(){
        this.prendas = new HashMap<>();
        this.contador = 0;
    }
    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        prendas.put(contador, listaDePrenda);
        contador+=1;
        return contador;
    }

    public void mostrarPrendas(){

        for (Map.Entry<Integer, List<Prenda>> entry : prendas.entrySet()) {
            Integer numero = entry.getKey();
            List<Prenda> prendas = entry.getValue();

            System.out.println("Prendas bajo el número " + numero + ":");
            for (Prenda prenda : prendas) {
                System.out.println("- " + prenda.getMarca() + " - " + prenda.getModelo());
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> devolucion = new ArrayList<>();
        if(prendas.containsKey(numero)){
            devolucion = prendas.get(numero);
            prendas.remove(numero);
            System.out.println("Prenda devuelta ");
        }else{
            System.out.println("numero no encontrado ");
        }
        return devolucion;
    }
}
