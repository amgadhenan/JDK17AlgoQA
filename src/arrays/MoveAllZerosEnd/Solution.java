package arrays.MoveAllZerosEnd;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

//OP --> https://www.geeksforgeeks.org/move-zeroes-end-array/
class Solution {
    // Function which pushes all zeros to end of an array.
    static void pushZerosToEnd(int arr[]) {
        final AtomicInteger count = new AtomicInteger(0);  // Count of non-zero elements

        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        IntStream.range(0, arr.length).filter(i -> arr[i] != 0).forEach(i -> arr[count.getAndIncrement()] = arr[i]);
        // incremented

        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        IntStream.range(count.get(), arr.length).forEach(i -> arr[i] = 0);
    }

    /*Driver function to check for above functions*/
    public static void main(String[] args) {
        var arr = new int[]{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        pushZerosToEnd(arr);
        System.out.println("Array after pushing zeros to the back: ");
        System.out.print(Arrays.toString(arr));
    }
}