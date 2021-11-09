package arrays.CountPairWithGivenSum;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class Solution {
    public static int getPairsCount(int[] arr, int sum) {
        AtomicInteger count = new AtomicInteger(0);
        IntStream.range(0, arr.length).forEach(i ->
                IntStream.range(i + 1, arr.length).filter(j -> arr[i] + arr[j] == sum)
                        .forEach(j -> count.getAndIncrement())
        );
        return count.get();
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int sum = 6;
        System.out.println("Pair Count is :" + getPairsCount(arr, sum));
    }
}