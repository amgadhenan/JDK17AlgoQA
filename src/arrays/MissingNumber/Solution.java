package arrays.MissingNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        IntStream.range(0, nums.length).filter(i -> Math.abs(nums[i]) - 1 < nums.length).forEach(i -> {
            nums[Math.abs(nums[i]) - 1] *= (nums[Math.abs(nums[i]) - 1] > 0) ? -1 : 1;
        });
        return IntStream.range(0, nums.length).filter(i -> nums[i] > 0).map(i -> i + 1)
                .boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 6};
        System.out.println(findDisappearedNumbers(a));
    }
}