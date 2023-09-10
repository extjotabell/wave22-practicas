    package org.example;

    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    public class GuardaRopa {
        Map<Integer, List<Prenda>> prendas;
        private int id;

        public GuardaRopa(int id) {
            this.id = id;
            prendas = new HashMap<>();
        }

        public Integer guardarPrendas(List<Prenda> listaDePrendas){
            Integer id = prendas.keySet().stream()
                        .mapToInt(Integer::intValue)
                        .max()
                        .orElse(0);
            id++;
            prendas.put(id, listaDePrendas);
            return id;
        }

        public void mostrarPrendas(){
            prendas.forEach((key, value) -> {
                System.out.println("=====" + key + "=====");
                value.forEach(prenda -> System.out.println(prenda.getMarca() + " " + prenda.getModelo()));
            });
        }

        public List<Prenda> devolverPrendas(Integer numero) {
            List<Prenda> prendasADevolver = prendas.get(numero);
            prendas.remove(numero);
            return prendasADevolver;
        }
    }
