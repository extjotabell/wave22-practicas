package com.renzobayarri;

public class Prototipo<T extends Number> {

    T increment;

    T initial;

    T lastNumber;

    public Prototipo(T increment) {
        this.increment = increment;
    }

    public T getNext(){
        Double last = lastNumber == null? 0 : lastNumber.doubleValue();
        Double result = last + increment.doubleValue();
        lastNumber = (T) result;
        return lastNumber;
    }

    public void reset(){
        lastNumber = null;
    }

    public void setInitial(T initial){
        this.initial = initial;
        lastNumber = initial;
    }
}
