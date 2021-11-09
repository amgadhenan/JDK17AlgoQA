package arrays.MissingNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public static List<Integer> findDisappearedNumbers(int[] arr) {
        IntStream.range(0, arr.length).filter(i -> Math.abs(arr[i]) - 1 < arr.length).forEach(i -> {
            arr[Math.abs(arr[i]) - 1] *= (arr[Math.abs(arr[i]) - 1] > 0) ? -1 : 1;
        });
        return IntStream.range(0, arr.length).filter(i -> arr[i] > 0).map(i -> i + 1)
                .boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 6};
        System.out.println(findDisappearedNumbers(a));
    }
}