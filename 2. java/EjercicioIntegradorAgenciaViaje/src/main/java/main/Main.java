package main;

public class Main {

    public static void main(String[] args) {
        Cliente cli1 = new Cliente("Rodrigo", "1234");
        Hotel hot1 = new Hotel("Hilton", 1000);
        Comida com1 = new Comida("Vianda", 100);
        BoletoViaje bol1 = new BoletoViaje("AA2134", 1000);
        Transporte tra1 = new Transporte("Taxi", 100);

        Localizador loc1 = new Localizador();
        loc1.agregarItem(hot1);
        loc1.agregarItem(com1);
        loc1.agregarItem(bol1);
        loc1.agregarItem(tra1);
        cli1.agregarLocalizador(loc1);

        Localizador loc2 = new Localizador();
        Hotel hot2 = new Hotel("Hilton", 1000);
        Hotel hot3 = new Hotel("Hilton", 1000);
        BoletoViaje bol2 = new BoletoViaje("AA2134", 1000);
        BoletoViaje bol3 = new BoletoViaje("AA2134", 1000);
        loc2.agregarItem(hot2);
        loc2.agregarItem(hot3);
        loc2.agregarItem(bol2);
        loc2.agregarItem(bol3);
        cli1.agregarLocalizador(loc2);

        System.out.println(cli1.toString());
        System.out.println(cli1.calcularPrecio(loc1));
        System.out.println(cli1.calcularPrecio(loc2));
    }
}
