import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Categoria categoria1 = new Categoria(1,"Circuito chico", "2 km por selva y arroyos");
        Categoria categoria2 = new Categoria(2, "Circuito medio", "5km por selva, arroyos y barro");
        Categoria categoria3 = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");
        List<Participante> participants = new ArrayList<>();
        List<Categoria> categories = new ArrayList<>();
        categories.add(categoria1);
        categories.add(categoria2);
        categories.add(categoria3);

        Scanner input = new Scanner(System.in);
        int options = 0;
        String dni;
        String name;
        String last_name;
        int age;
        String cellphone;
        String emergency_number;
        String blood_type;
        int category;

        while (options != 6){
            System.out.println("Select an option");
            System.out.println("1-Create a participant");
            System.out.println("2-Create a participant and enroll to a random category");
            System.out.println("3-List of participants in different categories");
            System.out.println("4-Unenroll a participant from a category");
            System.out.println("5-See how much money a category have collected");
            System.out.println("6-Exit");
            options = input.nextInt();
            switch (options){
                case 1:
                    System.out.println("Type the following information about the participant:");
                    System.out.println("DNI:");
                    dni = input.next();
                    System.out.println("Name:");
                    name = input.next();
                    System.out.println("Last name:");
                    last_name = input.next();
                    System.out.println("Age:");
                    age = input.nextInt();
                    System.out.println("Phone number:");
                    cellphone = input.next();
                    System.out.println("Emergency number:");
                    emergency_number = input.next();
                    System.out.println("Blood type:");
                    blood_type = input.next();
                    System.out.println("Category");
                    category = input.nextInt();

                    Participante participante = new Participante(participants.size(),dni,name,last_name,age,cellphone,emergency_number,blood_type,category);
                    participants.add(participante);

                    for(Categoria categoria : categories){
                        if(categoria.id == participante.category){
                            categoria.enrrolled.add(participante);
                            categoria.money += categoria.get_price(participante);
                            System.out.println("Participant has been enrolled to " + categoria.name + " category");
                            System.out.println("Has to pay $" + categoria.get_price(participante));
                        }
                    }

                    break;
                case 2:
                    System.out.println("Type the following information about the participant:");
                    System.out.println("DNI:");
                    dni = input.next();
                    System.out.println("Name:");
                    name = input.next();
                    System.out.println("Last name:");
                    last_name = input.next();
                    System.out.println("Age:");
                    age = input.nextInt();
                    System.out.println("Phone number:");
                    cellphone = input.next();
                    System.out.println("Emergency number:");
                    emergency_number = input.next();
                    System.out.println("Blood type:");
                    blood_type = input.next();

                    Random random = new Random();
                    category = random.nextInt(3) + 1;
                    Participante participante2 = new Participante(participants.size(),dni,name,last_name,age,cellphone,emergency_number,blood_type,category);
                    participants.add(participante2);

                    for(Categoria categoria : categories){
                        if(categoria.id == category){
                            categoria.enrrolled.add(participante2);
                            categoria.money += categoria.get_price(participante2);
                            System.out.println("Participant has been enrolled to " + categoria.name + " category");
                            System.out.println("Has to pay $" + categoria.get_price(participante2));
                        }
                    }
                    break;

                case 3:
                    for(Categoria categoria : categories){
                        System.out.println("People enrolled in " + categoria.name + ":");
                        for(Participante participant : categoria.enrrolled){
                            System.out.println("Participant n° " + participant.number);
                            System.out.println("Name:" + participant.name + "\n");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Give the number of participant you want to unenroll");
                    int unenrolled_participant = input.nextInt();
                    for(Participante participant : participants){
                        if(participant.number == unenrolled_participant){
                            System.out.println("Are you sure you want to unenroll " + participant.name + " " + participant.last_name);
                            String answer = input.next();
                            if(answer.toUpperCase().equals("Y")){
                                for(Categoria categoria : categories){
                                    if(participant.category == categoria.id){
                                        categoria.enrrolled.remove(participant.number);
                                    }
                                }
                                participant.category = 0;
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("Collection of each category:");
                    for(Categoria categoria : categories){
                        System.out.println(categoria.name + ": $" + categoria.money);
                    }

                    break;
            }
            System.out.println("Press any key to continue");
            input.nextLine();
            Runtime.getRuntime().exec("clear");
        }
    }
}
