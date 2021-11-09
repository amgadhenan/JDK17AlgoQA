## Find Missing Number in Array
You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in the list. One of the integers is missing in the list. Write an efficient code to find the missing integer.
Example:
```
Input: arr[] = {1, 2, 4, 6, 3, 7, 8}

Output: 5

Explanation: The missing number from 1 to 8 is 5



Input: arr[] = {1, 2, 3, 5}

Output: 4

Explanation: The missing number from 1 to 5 is 4
```
OP --> https://practice.geeksforgeeks.org/problems/missing-number-in-array

### Modern Solution
```java
class Solution {
    public static List<Integer> findDisappearedNumbers(int[] arr) {
        IntStream.range(0, arr.length).filter(i -> Math.abs(arr[i]) - 1 < arr.length).forEach(i -> {
            arr[Math.abs(arr[i]) - 1] *= (arr[Math.abs(arr[i]) - 1] > 0) ? -1 : 1;
        });
        return IntStream.range(0, arr.length).filter(i -> arr[i] > 0).map(i -> i + 1)
                .boxed().collect(Collectors.toList());
    }
}
```