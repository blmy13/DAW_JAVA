package Test;

import java.util.ArrayList;

public class List2 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(-8);
        nums.add(13);

        nums.removeIf(p -> p < 0);
        System.out.println(nums);
    }
}
