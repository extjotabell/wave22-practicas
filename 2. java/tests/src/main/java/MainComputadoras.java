import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainComputadoras {
    public static void main(String[] args) {
        Mac compu = new Mac(5);
        compu.arrancar();
        Computadora.explotar();

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        numbers.forEach(n -> System.out.println(n));

        //Más de una línea, debo especificar que se retorna con el return
        Computadora lambdaComputadora = (p,s) -> {
            System.out.println(p + "TUUUUUUUU" + s + s);
            return "Tutu";
        };

        //Al ser una sola línea, el ide lo interpreta como lo que se debe retornar (String)
        Computadora lambdaComputadora2 = (p,s) -> "Puchum Puchum" + s;

        print(lambdaComputadora);
        print(lambdaComputadora2);

        List<String> countries = new ArrayList<>();
        countries.add("Argentina");
        countries.add("Italia");
        countries.add("Alemania");
        countries.add("España");

        countries = countries.stream().map(String::toUpperCase)
                .filter(country -> country.startsWith("A"))
                .collect(Collectors.toList());

        countries.forEach(System.out::println);

        compu.hola();

    }

    public static void print(Computadora computadora){
        System.out.println(computadora.arrancar("¡", "!"));
    }
}
