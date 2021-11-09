package arrays.AlternatePositiveNegative;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

//OP --> https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space
class Solution {

    static void rearrange(int[] arr) {
        final AtomicInteger outOfPlace = new AtomicInteger(-1);
        IntStream.range(0, arr.length).forEach(i -> {
            if (outOfPlace.get() >= 0 &&
                    ((arr[i] >= 0 && arr[outOfPlace.get()] < 0) || arr[i] < 0 && arr[outOfPlace.get()] >= 0)) {

                var temp = arr[i];
                IntStream.rangeClosed(outOfPlace.get() + 1, i)
                        .boxed()
                        .sorted(Collections.reverseOrder()).forEach(j -> arr[j] = arr[j - 1]);
                arr[outOfPlace.get()] = temp;
                outOfPlace.set(i - outOfPlace.get() >= 2 ? outOfPlace.addAndGet(2) : -1);
            }

            if (outOfPlace.get() == -1)
                outOfPlace.set((arr[i] >= 0 && i % 2 == 0) || (arr[i] < 0 && i % 2 == 1) ? i : -1);
        });
    }


    // Driver Code
    public static void main(String[] args) {
        var arr = new int[]{-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        System.out.println("Given array is: " + Arrays.toString(arr));
        rearrange(arr);
        System.out.println("RearrangeD array is: " + Arrays.toString(arr));

        arr = new int[]{-5, -3, -4, -5, -6, 2, 8, 9, 1, 4};
        System.out.println("Given array is: " + Arrays.toString(arr));
        rearrange(arr);
        System.out.println("RearrangeD array is: " + Arrays.toString(arr));

        arr = new int[]{5, 3, 4, 2, 1, -2, -8, -9, -1, -4};
        System.out.println("Given array is: " + Arrays.toString(arr));
        rearrange(arr);
        System.out.println("RearrangeD array is: " + Arrays.toString(arr));

        arr = new int[]{-5, 3, -4, -7, -1, -2, -8, -9, 1, -4};
        System.out.println("Given array is: " + Arrays.toString(arr));
        rearrange(arr);
        System.out.println("RearrangeD array is: " + Arrays.toString(arr));

    }
}