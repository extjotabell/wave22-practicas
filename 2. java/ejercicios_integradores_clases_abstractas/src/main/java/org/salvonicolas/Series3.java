package org.salvonicolas;

public class Series3 extends Prototype<Integer>{
    public Series3() {
        initSeries();
    }
    public Series3(Integer initValue) {
        initSeries(initValue);
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

    private void initSeries() {
        setInitialValue(0);
        setCurrentValue(0);
    }
    private void initSeries(Integer init) {
        setInitialValue(init);
        setCurrentValue(init);
    }
}
