package leetcode.sum;

import java.util.Arrays;

public class ThreeSumClosest {
    /**
     * 16. 3Sum Closest
     * Given an array nums of n integers and an integer target,
     * find three integers in nums such that the sum is closest to target.
     * Return the sum of the three integers.
     * You may assume that each input would have exactly one solution.
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length <= 3) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
        Arrays.sort(nums);
        int closet = nums[0] + nums[1] + nums[2];
        int minDiff = Math.abs(closet - target);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])//因为已经排过序 所以相同的数肯定相邻 因此去掉相邻相同的就去掉所以相同的了
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int newDiff = Math.abs(sum - target);
                if (newDiff < minDiff) {
                    minDiff = newDiff;
                    closet = sum;
                }
                if (sum > target)
                    right--;
                else
                    left++;
                //相同的数直接pass
                while (left < right && left > 0 && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                }

            }
        }
        return closet;
    }
}
