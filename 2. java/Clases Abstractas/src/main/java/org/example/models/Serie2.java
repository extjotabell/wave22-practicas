package org.example.models;

public class Serie2 extends SerieBasic<Integer>{
    public Serie2() {
        initSerie();
    }
    public Serie2(Integer initValue) {
        initSerie(initValue);
    }

    @Override
    public Integer getNext() {
        setCurrentValue(getCurrentValue() + 2);
        System.out.println(getCurrentValue());
        return getCurrentValue();
    }

    @Override
    public void reset() {
        setCurrentValue(getInitialValue());
    }

    @Override
    public void initValue(Integer initialValue) {
        setInitialValue(initialValue);
    }

    private void initSerie() {
        setInitialValue(0);
        setCurrentValue(0);
    }
    private void initSerie(Integer init) {
        setInitialValue(init);
        setCurrentValue(init);
    }
}

