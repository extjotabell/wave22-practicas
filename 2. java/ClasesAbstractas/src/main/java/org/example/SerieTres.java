package org.example;

public class SerieTres extends SeriePrototipo<Integer>{
    private Integer init;
    private Integer actual;

    public SerieTres() {
    }

    public SerieTres(Integer init) {
        this.inicial(init);
    }

    @Override
    public Integer valorSig() {
        this.actual += 3;
        return this.actual;
    }

    @Override
    public void resetSerie() {
        this.actual = init;
    }

    @Override
    public void inicial(Integer init) {
        this.init = init;
        this.actual = init;
    }
}
