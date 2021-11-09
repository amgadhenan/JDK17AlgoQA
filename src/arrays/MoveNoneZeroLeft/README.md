## Move all zeroes to end of array | Set-2 (Using single traversal)
Given an array of n numbers. The problem is to move all the 0’s to the end of the array while maintaining the order of the other elements. Only single traversal of the array is required.
Examples:
```
Input : arr[]  = {1, 2, 0, 0, 0, 3, 6}
Output : 1 2 3 6 0 0 0

Input: arr[] = {0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9}
Output: 1 9 8 4 2 7 6 9 0 0 0 0 0
```
OP --> https://www.geeksforgeeks.org/move-zeroes-end-array-set-2-using-single-traversal/

### Modern Solution
```java
class Solution {
    static void moveNoneZerosLeft(int[] arr) {
        final AtomicInteger count = new AtomicInteger(0); 
        IntStream.range(0, arr.length).filter(i -> arr[i] != 0).forEach(i -> {
            var temp = arr[count.get()];
            arr[count.getAndIncrement()] = arr[i];
            arr[i] = temp;
        });
    }
}
```