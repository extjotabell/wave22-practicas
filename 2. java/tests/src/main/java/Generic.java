public class Generic <T extends Number>{
    private T genericField;
    private Integer numericField;

    public Generic(T genericField, Integer numericField){
        this.genericField = genericField;
        this.numericField = numericField;
    }

    public T getGenericField(){
        return this.genericField;
    }

    public void setGenericField(T genericField){
        this.genericField = genericField;
    }
}
