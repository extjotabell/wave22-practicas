public class Main {
    public static void main(String[] args) {
        Categoria circuitoChico = new Categoria(1, "circuitoChico","2 km por selva y arroyos");
        Categoria circuitoMedio = new Categoria(2, "circuitoMedio","5 km por selva, arroyos y barro");
        Categoria circuitoAvanzado = new Categoria(3, "circuitoAvanzado","10 km por selva, arroyos, barro y escalada en piedra.");

        Participante randy = new Participante(1,951323,"randy","mendoza",20,123123,31232,"A");
        Participante camila = new Participante(2,4234,"camila","soledad",24,534543,567567,"A");
        Participante nicolas = new Participante(3,73773,"nicolas","gug",17,978987,57567987,"A");
        Participante martin = new Participante(4,73773,"martin","johanna",18,5115,78687,"A");

        Inscripcion inscripcionCircuitoChico = new Inscripcion(1, circuitoChico, camila);
        try{
            Inscripcion inscripcionCircuitoAvanzado = new Inscripcion(2, circuitoAvanzado, nicolas);
        }catch (RuntimeException e){
            System.out.println("Hubo un error inscribiendo al participante");
        }
        Inscripcion inscripcionCircuitoAvanzado = new Inscripcion(2, circuitoAvanzado, nicolas);
        Inscripcion inscripcionCircuitoMedio = new Inscripcion(3, circuitoMedio, randy);





    }
}
