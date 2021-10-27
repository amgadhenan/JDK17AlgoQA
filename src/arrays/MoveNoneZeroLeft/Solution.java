package arrays.MoveNoneZeroLeft;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

//OP --> https://www.geeksforgeeks.org/move-zeroes-end-array/
class Solution {
    // Function which pushes all zeros to end of an array.
    static void moveNoneZerosLeft(int arr[]) {
        final AtomicInteger count = new AtomicInteger(0); // Count of non-zero elements

        // Traverse the array. If arr[i] is
        // non-zero, then swap the element at
        // index 'count' with the element at
        // index 'i'
        IntStream.range(0, arr.length).filter(i -> arr[i] != 0).forEach(i -> {
            var temp = arr[count.get()];
            arr[count.getAndIncrement()] = arr[i];
            arr[i] = temp;
        });

    }

    /*Driver function to check for above functions*/
    public static void main(String[] args) {
        var arr = new int[]{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        moveNoneZerosLeft(arr);
        System.out.println("Array after pushing zeros to the back: ");
        System.out.print(Arrays.toString(arr));
    }
}