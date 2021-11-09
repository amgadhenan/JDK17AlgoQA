## Non-Repeating Element

Find the first non-repeating element in a given array arr of N integers. Note: Array consists of only positive and
negative integers and not zero.

Example 1:

```
Input : arr[] = {-1, 2, -1, 3, 2}
Output : 3
Explanation:
-1 and 2 are repeating whereas 3 is 
the only number occuring once.
Hence, the output is 3. 
```

Example 2:

```
Input : arr[] = {1, 1, 1}
Output : 0
```

OP --> https://www.geeksforgeeks.org/non-repeating-element/

### Modern Solution

```java
class Solution {
    static int findFirstNonRepeating(int[] arr) {
        Map<Integer, Integer> repeatCountMap = new HashMap<>();
        IntStream.range(0, arr.length).forEach(i -> {
            if (repeatCountMap.containsKey(arr[i])) {
                repeatCountMap.put(arr[i], repeatCountMap.get(arr[i]) + 1);
            } else {
                repeatCountMap.put(arr[i], 1);
            }
        });
        return repeatCountMap.entrySet().stream().filter(entry -> entry.getValue() == 1)
                .findFirst().orElse(new AbstractMap.SimpleImmutableEntry<>(0, 0)).getKey();
    }
}
```