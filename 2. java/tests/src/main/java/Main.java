    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.LinkedList;
    import java.util.List;
    import java.util.stream.Collectors;
    import java.util.stream.Stream;

    public class Main {
        public static void main(String[] args) {

            Generic<Double> generico = new Generic<>(21.13, 2);
            System.out.println(generico.getGenericField());
            Auto auto = new Auto();
            auto.acelerar();
            auto.cambiarMarcha();

            List<String> myList = new ArrayList<>();
            myList.add("Hola");
            myList.add("Messi");
            myList.add("Taylor Swift");

            System.out.println();

            myList.stream().forEach(System.out::println);
            Stream.of("Argentina", "Alemania" , "Colombia", "Uruguay", "Italia").map
                    (country -> country.toUpperCase()).forEach(System.out::println);

            System.out.println();

            List<String> stringList = Stream.of("Justin Bieber", "Selena Gomez",
                    "Olivia Rodrigo").map(singer -> singer.toUpperCase()).collect(Collectors.toList());
            stringList.forEach(System.out::println);

            System.out.println();

            Integer[] numberArray = {4, 2, 11, 3, 5, 9};
            List<Integer> numbers = Arrays.asList(numberArray);
            numbers.stream().filter(number -> number >=5).forEach(System.out::println);

            System.out.println();

            Integer[] intArray = {4, 2, 6, 9, 8, 5};
            List<Integer> intList = Arrays.asList(intArray);
            Integer result = intList.stream().mapToInt(number -> number*number).sum();
            System.out.println(result);

            System.out.println();

            List<Empleado> empleadoList = new ArrayList<>();
            empleadoList.add(new Empleado(1, "Gonzalo Alberti", "Contabilidad"));
            empleadoList.add(new Empleado(2, "Mariana Lisoski", "Sistemas"));
            empleadoList.add(new Empleado(3, "Esteban Gomez", "Sistemas"));
            empleadoList.add(new Empleado(4, "Amelia Jaciuk", "Administracion"));
            empleadoList.add(new Empleado(5, "Carlos Perez", "Administracion"));

            empleadoList.stream().filter(empleado -> empleado.getDepartment().equals("Sistemas")).
                    sorted((x,y) -> x.getName().compareToIgnoreCase(y.getName())).
                    forEach(Empleado::printEmpleado);

        }
    }