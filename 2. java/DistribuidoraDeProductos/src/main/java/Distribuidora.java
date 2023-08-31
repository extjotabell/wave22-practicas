import javax.swing.*;

public class Distribuidora {
    public static void main(String[] args) {
        Perecedero prod1 = new Perecedero("p1", 10, 2);
        Perecedero prod2 = new Perecedero("p2", 20, 1);
        Perecedero prod3 = new Perecedero("p3", 30, 3);
        Perecedero prod4 = new Perecedero("p4", 40, 9);
        Perecedero prod5 = new Perecedero("p5", 50, 9);

        NoPerecedero prod6 = new NoPerecedero("p6", 60, "");
        NoPerecedero prod7 = new NoPerecedero("p7", 70, "");
        NoPerecedero prod8 = new NoPerecedero("p8", 80, "");
        NoPerecedero prod9 = new NoPerecedero("p9", 90, "");
        NoPerecedero prod10 = new NoPerecedero("p10", 100, "");

        Producto productos[] = {prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9, prod10};

        double total = 0;
        for (Producto p : productos) {
            total += p.calcular(5);
        }
        System.out.println(total);
    }
}
