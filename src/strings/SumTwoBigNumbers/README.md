## Sum of two large numbers
Given two numbers as strings. The numbers may be very large (may not fit in long long int), the task is to find sum of these two numbers.

Examples:
```
Input  : str1 = "3333311111111111", 
         str2 =   "44422222221111"
Output : 3377733333332222

Input  : str1 = "7777555511111111", 
         str2 =    "3332222221111"
Output : 7780887733332222
```
OP --> https://www.geeksforgeeks.org/sum-two-large-numbers/

### Modern Solution
```java
class Solution {
    static String findSum(String str1, String str2) {
        StringBuilder result = new StringBuilder("");
        AtomicInteger carry = new AtomicInteger(0);
        AtomicInteger i1 = new AtomicInteger(str1.length() - 1);
        AtomicInteger i2 = new AtomicInteger(str2.length() - 1);
        IntStream.range(0, Math.max(str1.length(), str2.length())).forEach(i -> {
            var num1 = i1.get() < str1.length() && i1.get() >= 0 ? (str1.charAt(i1.getAndDecrement()) - '0') : 0;
            var num2 = i2.get() < str2.length() && i2.get() >= 0 ? (str2.charAt(i2.getAndDecrement()) - '0') : 0;
            result.append((char) ((num1 + num2 + carry.get()) % 10 + '0'));
            carry.set((num1 + num2 + carry.get()) / 10);
        });
        if (carry.get() > 0) {
            result.append((char) (carry.get() + '0'));
        }
        return result.reverse().toString();
    }
}