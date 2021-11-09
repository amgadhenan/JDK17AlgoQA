package arrays.FirstNonRepeatingElement;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Solution {
    static int findFirstNonRepeating(int[] arr) {
        Map<Integer, Integer> repeatCountMap = new HashMap<>();
        IntStream.range(0, arr.length).forEach(i -> {
            if (repeatCountMap.containsKey(arr[i])) {
                repeatCountMap.put(arr[i], repeatCountMap.get(arr[i]) + 1);
            } else {
                repeatCountMap.put(arr[i], 1);
            }
        });
        return repeatCountMap.entrySet().stream().filter(entry -> entry.getValue() == 1)
                .findFirst().orElse(new AbstractMap.SimpleImmutableEntry<>(0, 0)).getKey();
    }

    public static void main(String[] args) {
        var arr = new int[]{-1, 2, -1, 3, 2};
        System.out.println("The first non-repeating element is: " + findFirstNonRepeating(arr));
        arr = new int[]{1, 1, 1};
        System.out.println("The first non-repeating element is: " + findFirstNonRepeating(arr));
    }
}