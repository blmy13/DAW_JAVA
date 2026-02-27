package Test;

import java.util.Arrays;

public class Arrays1 {
    public static void main(String[] args) {
        int[] num= {45, 15, 89, 2, 14};
        Arrays.sort(num);
        System.out.println("Posició número 14: " + Arrays.binarySearch(num, 14));
        System.out.println("Array ordenat: " + Arrays.toString(num));

    }
}
