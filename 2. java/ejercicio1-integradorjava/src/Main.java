import domain.SerieImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------SERIE DE 2------------");
        SerieImpl serie = new SerieImpl(2);
       serie.nextValue();
       serie.nextValue();
       serie.nextValue();
       serie.nextValue();

        System.out.println("------------SERIE DE 3-------------");
       SerieImpl serieTres = new SerieImpl(3);
       serieTres.nextValue();
       serieTres.nextValue();
       serieTres.nextValue();

        System.out.println("----------------SERIE DE 1--------------");
       SerieImpl serieUno = new SerieImpl(1);
        serieUno.nextValue();
        serieUno.nextValue();
        serieUno.nextValue();
        serieUno.nextValue();
       serieUno.nextValue();

        System.out.println("------- probando serie de 2 seteando a 1-------");
        serie.setInitialValue(1);
        serie.nextValue();
        serie.nextValue();
        serie.nextValue();
        serie.nextValue();
        serie.nextValue();

        System.out.println("------reiniciando la serie 2-----------");
        serie.resetSerie();
        serie.nextValue();
        serie.nextValue();
        serie.nextValue();


    }
}
