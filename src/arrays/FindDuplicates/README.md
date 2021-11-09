## Find Duplicates in Array
Given an array of n elements containing elements from 0 to n-1, with any of these numbers appearing any number of times, find these repeating numbers in O(n) and using only constant memory space.

Example:

```
Input: n = 7 , array = {1, 2, 3, 1, 3, 6, 6}

Output: 1, 3 and 6.

Explanation: Duplicate element in the array are 1 , 3 and 6



Input: n = 6, array = {5, 3, 1, 3, 5, 5}

Output: 3 and 5.

Explanation: Duplicate element in  the array are 3 and 6
```
OP --> https://practice.geeksforgeeks.org/problems/find-duplicates-in-an-array

### Modern Solution
```java
class Solution {
    static List<Integer> findRepeating(int[] arr) {
        Arrays.stream(arr).map(j -> j % arr.length).forEach(i -> arr[i] += arr.length);
        return IntStream.range(0, arr.length).filter(i -> arr[i] / arr.length >= 2)
                .boxed().collect(Collectors.toList());
    }
}
```