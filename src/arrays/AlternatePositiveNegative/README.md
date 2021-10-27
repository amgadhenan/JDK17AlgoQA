## Rearrange array in alternating positive & negative items with O(1) extra space | Set 1
Given an array of positive and negative numbers, arrange them in an alternate fashion such that every positive number is followed by negative and vice-versa maintaining the order of appearance.
Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array. If there are more negative numbers, they too appear in the end of the array.

Examples :
```
Input:  arr[] = {1, 2, 3, -4, -1, 4}
Output: arr[] = {-4, 1, -1, 2, 3, 4}

Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}
```
OP --> https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space

### Modern Solution
```java
class Solution {
    void rearrange(int arr[]) {
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
}
```