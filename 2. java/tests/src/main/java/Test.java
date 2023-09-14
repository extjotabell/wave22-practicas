import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = {10, 9, 4, 1, 5, 3};
        int[] array = burbuja(a);
        for (int number : array) {
            System.out.println(number);
        }
    }

    public static int[] burbuja(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
