package org.example.models;

public class Serie3 extends SerieBasic<Integer>{
    public Serie3() {
        initSerie();
    }
    public Serie3(Integer initValue) {
        initSerie(initValue);
    }

    @Override
    public Integer getNext() {
        setCurrentValue(getCurrentValue() + 3);
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

