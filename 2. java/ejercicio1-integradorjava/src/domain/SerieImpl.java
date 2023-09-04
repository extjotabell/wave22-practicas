package domain;

import java.util.Objects;

public class SerieImpl implements ISerieNumerica {
    private Integer value;
    private Integer valueCache;
    public SerieImpl(Integer intValue) {
        this.value = intValue;
        setValueCache(intValue);
    }

    @Override
    public void nextValue() {
        if(Objects.equals(value, valueCache)) {
            System.out.println(valueCache);
        } else {
            System.out.println(value);
        }
        value += valueCache;
    }

    @Override
    public void resetSerie() {
        setValue(valueCache);
    }

    @Override
    public void setInitialValue(Integer initalValue) {
         setValue(initalValue);
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setValueCache(Integer valueCache) {
        this.valueCache = valueCache;
    }
}
