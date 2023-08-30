package com.renzobayarri;

public class Main {
    public static void main(String[] args) {

        Category circuitoChico = new Category(1, "Circuito Chico", "2 km por selva y arroyos", 1500,1300,true);
        Category circuitoMedio = new Category(2, "Circuito Medio", "5 km por selva, arroyos y barro", 2300,2000,true);
        Category circuitoAvanzado = new Category(3, "Circuito Avanzado", "10 km por selva, arroyos, barro y escalada en piedra", 2800,0,false);

        Participant renzo = new Participant(1, 36964073, "Renzo", "Bayarri", 31, "2612516353", "-", "O+");
        Participant olivia = new Participant(1, 36964073, "Olivia", "Bayarri", 17, "2612516353", "-", "O+");

        Registration registration = new Registration(1, circuitoAvanzado, renzo);
        Registration registration1 = new Registration(2, circuitoChico, olivia);

        circuitoChico.printRegistrations();
        circuitoChico.removeParticipant(olivia);

        circuitoChico.printIncome();
        printTotalIncome();
    }

    public static void printTotalIncome(){
        double totalIncome = 0;
        for(Category cat : Category.categories){
            System.out.println("Income for the category " + cat.getName());
            double income = cat.getIncome();
            System.out.println("Income: " + income);
            totalIncome += income;
        }
        System.out.println("-------------------------------------");
        System.out.println("Total income: " + totalIncome);

    }
}