package org.salvonicolas;

public abstract class Prototype<T extends Number> {
    private T initialValue;
    private T currentValue;
    public abstract T getNext();
    public abstract void reset();
    public abstract void initValue(T initialValue);

    public T getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(T initialValue) {
        this.initialValue = initialValue;
    }

    public T getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(T currentValue) {
        this.currentValue = currentValue;
    }
}
