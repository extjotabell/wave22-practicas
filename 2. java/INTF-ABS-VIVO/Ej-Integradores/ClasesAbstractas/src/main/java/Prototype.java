public abstract class Prototype<T extends Number> {

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public abstract T next();

    public abstract void reset();

    public abstract void setFirstTo(T firstValue);

}
