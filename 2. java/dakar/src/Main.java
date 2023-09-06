// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Carrera miCarrera = new Carrera(1000, 10000, "Carrera 1", 6);
        miCarrera.darDeAltaAuto(100, 8, 20, "ABC123");
        miCarrera.darDeAltaAuto(100, 8, 20, "ABC123");
        miCarrera.darDeAltaAuto(130, 10, 25, "GHI123");

        miCarrera.darDeAltaMoto(80, 6, 30, "JKL456");
        miCarrera.darDeAltaMoto(85, 5, 28, "MNO789");
        miCarrera.darDeAltaMoto(85, 5, 28, "MNO789");
        miCarrera.darDeAltaMoto(80, 6, 30, "JKL456");

        Vehiculo auto4 = new Autos(130, 10, 25, "GHI123", 1600, 4);
        Vehiculo moto4 = new Motos(90, 8, 35, "STU456", 300, 2);


    }
}