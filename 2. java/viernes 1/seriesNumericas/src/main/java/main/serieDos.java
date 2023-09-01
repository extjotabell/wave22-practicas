package main;

public class serieDos extends SerieProgresiva<Integer>{

    private Integer inicial= super.getValorActual();

    public serieDos(Integer valorInicial) {
        super(valorInicial);
    }



    @Override
    protected Integer getValorInicial() {
        return null;
    }



    @Override
    public Integer calcularSiguienteValor(){

            inicial=inicial+2;
            return inicial;
        }
    }
}
