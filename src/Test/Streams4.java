package Test;

import java.util.List;

public class Streams4 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        nums.stream()
                .filter(p -> p % 2 == 0)
                .map(p -> p * 10)
                .forEach(System.out::println);
    }
}
