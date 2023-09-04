package org.example;

public abstract class SeriePrototipo <T extends Number> {
    public abstract T valorSig();
    public abstract void resetSerie();
    public abstract void inicial(T init);
}
