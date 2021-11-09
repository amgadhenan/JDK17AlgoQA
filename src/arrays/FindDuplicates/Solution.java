package arrays.FindDuplicates;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    static List<Integer> findRepeating(int[] arr) {
        Arrays.stream(arr).map(j -> j % arr.length).forEach(i -> arr[i] += arr.length);
        return IntStream.range(0, arr.length).filter(i -> arr[i] / arr.length >= 2)
                .boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        var arr = new int[]{1, 6, 3, 1, 3, 6, 6};
        System.out.println("The repeating elements are: " + findRepeating(arr));
        arr = new int[]{5, 3, 1, 3, 5, 5};
        System.out.println("The repeating elements are: " + findRepeating(arr));
    }
}