package org.example;

public class SerieDos extends SeriePrototipo<Integer>{
    private Integer init;
    private Integer actual;

    public SerieDos() {
    }

    public SerieDos(Integer init) {
        this.inicial(init);
    }

    @Override
    public Integer valorSig() {
        this.actual = this.actual + 2;
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
