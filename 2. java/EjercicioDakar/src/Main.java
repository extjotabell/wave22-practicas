// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Carrera carrera = new Carrera(200.0, 100000.0, "Dakar", 5);


        carrera.darDeAltaAuto(100,20,24.5,"AFJ231");
        carrera.darDeAltaAuto(120,30,18.5,"AFJ232");
        carrera.darDeAltaAuto(90,10,16.5,"AFJ233");
        carrera.darDeAltaAuto(90,40,17.5,"AFJ234");
        carrera.darDeAltaAuto(70,34,14.5,"AFJ235");

        carrera.socorrerAuto("AFJ235");
        carrera.socorrerAuto("AFJ233");


        Vehiculo vehiculo = carrera.definirGanador();
        System.out.println(vehiculo);

        carrera.eliminarVehiculo(vehiculo);

        System.out.println(carrera.definirGanador());
    }
}