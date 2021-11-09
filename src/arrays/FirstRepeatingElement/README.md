## Find Duplicates in Array

Given an array arr[] of size n, find the first repeating element. The element should occurs more than once and the index
of its first occurrence should be the smallest.

Example 1:

```
Input:
n = 7
arr[] = {1, 5, 3, 4, 3, 5, 6}
Output: 2
Explanation: 
5 is appearing twice and 
its first appearence is at index 2 
which is less than 3 whose first 
occuring index is 3.
```

Example 2:

```
Input:
n = 4
arr[] = {1, 2, 3, 4}
Output: -1
Explanation: 
All elements appear only once so 
answer is -1.
```

OP --> https://www.geeksforgeeks.org/find-first-repeating-element-array-integers/

### Modern Solution

```java
class Solution {
    static int findFirstRepeating(int arr[]) {
        AtomicInteger result = new AtomicInteger(-1);
        Set<Integer> set = new HashSet<>();
        IntStream.range(0, arr.length).map(i -> arr.length - i - 1).forEach(i -> {
            if (set.contains(arr[i])) {
                result.set(i);
            } else {
                set.add(arr[i]);
            }
        });
        return result.get() != -1 ? arr[result.get()] : result.get();
    }
}
```