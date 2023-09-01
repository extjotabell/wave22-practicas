public class Main {

    public static void main(String[] args) {


        ProgresiveSeries two = new ProgresiveSeries(2);
        System.out.println("Two series:");
        System.out.println(two.next());
        System.out.println(two.next());
        System.out.println(two.next());
        System.out.println(two.next());

        ProgresiveSeries three = new ProgresiveSeries(3);
        System.out.println("Three series:");
        System.out.println(three.next());
        System.out.println(three.next());
        System.out.println(three.next());
        System.out.println(three.next());
        three.reset();
        System.out.println("Reset 3 series");
        System.out.println(three.next());
        System.out.println(three.next());
        System.out.println("Set 3 series to 7 as first value:");
        three.setFirstTo(7);
        System.out.println(three.next());
        System.out.println(three.next());


    }

}
