public class SequenceGenerator {
    private int value;
    private int increment;

    public SequenceGenerator(int increment) {
        this.increment = increment;
        this.value = increment - 1;
    }

    public void nextValue() {
        value += increment;
        System.out.println("Primera vez " + value);
    }

    public static void main(String[] args) {
        SequenceGenerator generator1 = new SequenceGenerator(1);
        SequenceGenerator generator2 = new SequenceGenerator(2);
        SequenceGenerator generator3 = new SequenceGenerator(3);

        for (int i = 0; i < 4; i++) {
            generator1.nextValue();
        }

        System.out.println("-------------para 2----------------");
        for (int i = 0; i < 4; i++) {
            generator2.nextValue();
        }

        System.out.println("---------------para 3--------------");
        for (int i = 0; i < 4; i++) {
            generator3.nextValue();
        }
    }
}




