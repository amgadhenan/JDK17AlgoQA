## Count pairs with given sum
Given an array of integers, and a number ‘sum’, find the number of pairs of integers in the array whose sum is equal to ‘sum’.

Examples:
```
Input  :  arr[] = {1, 5, 7, -1}, 
          sum = 6
Output :  2
Pairs with sum 6 are (1, 5) and (7, -1)

Input  :  arr[] = {1, 5, 7, -1, 5}, 
          sum = 6
Output :  3
Pairs with sum 6 are (1, 5), (7, -1) &
                     (1, 5)         

Input  :  arr[] = {1, 1, 1, 1}, 
          sum = 2
Output :  6
There are 3! pairs with sum 2.

Input  :  arr[] = {10, 12, 10, 15, -1, 7, 6, 
                   5, 4, 2, 1, 1, 1}, 
          sum = 11
Output :  9
```
OP --> https://www.geeksforgeeks.org/count-pairs-with-given-sum/

### Modern Solution
```java
class Solution {
    public static int getPairsCount(int[] arr, int sum) {
        AtomicInteger count = new AtomicInteger(0);
        IntStream.range(0, arr.length).forEach(i ->
                IntStream.range(i + 1, arr.length).filter(j -> arr[i] + arr[j] == sum)
                        .forEach(j -> count.getAndIncrement())
        );
        return count.get();
    }
}
```