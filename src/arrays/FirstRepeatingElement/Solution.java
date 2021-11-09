package arrays.FirstRepeatingElement;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class Solution {
    static int findFirstRepeating(int[] arr) {
        AtomicInteger result = new AtomicInteger(-1);
        Set<Integer> set = new HashSet<>();
        IntStream.range(0, arr.length).map(i -> arr.length - i - 1).forEach(i -> {
            if (set.contains(arr[i])) {
                result.set(i);
            } else {
                set.add(arr[i]);
            }
        });
        return result.get() != -1 ? arr[result.get()] : result.get();
    }

    public static void main(String[] args) {
        var arr = new int[]{1, 5, 3, 4, 3, 5, 6};
        System.out.println("The first repeating element is: " + findFirstRepeating(arr));
        arr = new int[]{1, 2, 3, 4};
        System.out.println("The first repeating element is: " + findFirstRepeating(arr));
    }
}