## Find Common in Sorted Arrays

Given three arrays sorted in non-decreasing order, print all common elements in these arrays.

Examples:

```
Input: 
ar1[] = {1, 5, 10, 20, 40, 80} 
ar2[] = {6, 7, 20, 80, 100} 
ar3[] = {3, 4, 15, 20, 30, 70, 80, 120} 
Output: 20, 80

Input: 
ar1[] = {1, 5, 5} 
ar2[] = {3, 4, 5, 5, 10} 
ar3[] = {5, 5, 10, 20} 
Output: 5, 5
```

OP --> https://practice.geeksforgeeks.org/problems/common-elements

### Modern Solution -- not actually nothing to modernize :(

```java
class Solution {
    static List<Integer> findCommon(int[] ar1, int[] ar2, int[] ar3) {
        int i = 0, j = 0, k = 0;
        List<Integer> result = new ArrayList<>();
        do {
            if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
                result.add(ar1[i]);
                i++;
                j++;
                k++;
            } else if (ar1[i] < ar2[j]) {
                i++;
            } else if (ar2[j] < ar3[k]) {
                j++;
            } else {
                k++;
            }
        } while (i < ar1.length && j < ar2.length && k < ar3.length);
        return result;
    }
}
```