import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    /* List<String> arrList = new ArrayList<>();

        arrList.add("Messi");
        arrList.add("Francia");

        Iterator<String> it = arrList.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
 */
        System.out.println("------------------------------------------------------");

        Categoria categoriaChico = new Categoria(1,"Circuito Chico","2 km por selva y arroyos",1300,1500, true);
        Categoria categoriaMedio = new Categoria(1,"Circuito Medio","5 km por selva, arroyos y barro",2000,2300, true);
        Categoria categoriaAvanzado= new Categoria(1,"Circuito Avanzado","10 km por selva, arroyos, barro y escalada en piedra",0,2800, false);

        Participante participante1 = new Participante(1,123,"Jose","San Martin",18,"1234567890","1234567890","O+");
        Participante participante2 = new Participante(2,456,"Manuel","Belgrano",22,"1234567890","1234567890","A+");
        Participante participante3 = new Participante(3,789,"Juan Felipe","Ibarra",41,"1234567890","1234567890","B+");
        Participante participante4 = new Participante(4,124,"Mario R","Santucho",16,"1234567890","1234567890","O-");
        Participante participante5 = new Participante(5,357,"Filippa","Leiva",18,"12335677","46788997","AB");

        Inscripcion inscripcionChico = new Inscripcion(1,categoriaChico,participante1);
        Inscripcion inscripcionChico2 = new Inscripcion(2,categoriaChico,participante4);
        Inscripcion inscripcionMedio = new Inscripcion(1,categoriaMedio,participante3);
        Inscripcion inscripcionMedio2 = new Inscripcion(2,categoriaMedio,participante2);
        Inscripcion inscripcionAvanzado = new Inscripcion(1,categoriaAvanzado,participante2);
        Inscripcion inscripcionAvanzado2 = new Inscripcion(2,categoriaAvanzado,participante4);



        Inscripcion inscripcionRandom = new Inscripcion(3,participante5);

        System.out.println("------------------------------------------------------");
        categoriaChico.printInscripcions();
        System.out.println("------------------------------------------------------");
        categoriaMedio.printInscripcions();
        System.out.println("------------------------------------------------------");
        categoriaAvanzado.printInscripcions();
        System.out.println("------------------------------------------------------");
        categoriaMedio.eliminarParticipante(participante2, categoriaMedio);
    }
}