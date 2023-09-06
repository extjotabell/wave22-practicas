import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> guardarropa = new HashMap<>();
    private int id = 0;
    public Integer guardarPrenda(List<Prenda> listaDePrenda){
        id = id + 1;
        guardarropa.put(id,listaDePrenda);
        return id;
    }

    public void mostrarPrenda(){
        for (Map.Entry<Integer,List<Prenda>> prendas : guardarropa.entrySet()){
            Integer id = prendas.getKey();
            List<Prenda> listaPrendas = prendas.getValue();
            System.out.println("ID : " + id + " Prendas: " + listaPrendas);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> listaPrendas = new ArrayList<>();
        for (Map.Entry<Integer,List<Prenda>> prendas : guardarropa.entrySet()){
            Integer id = prendas.getKey();

            if(numero == id){
                listaPrendas.add((Prenda) prendas.getValue());
            }

        }
        return listaPrendas;
    }
}
