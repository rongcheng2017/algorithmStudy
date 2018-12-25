package leetcode.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 18. 4Sum
 *
 * Given an array nums of n integers and an integer target, are there elements a, b, c
 * , and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate quadruplets.
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int low = j + 1;
                int height = nums.length - 1;
                while (low < height) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[height];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[height]));
                        while (low < height && nums[low] == nums[low + 1]) low++;
                        while (low < height && nums[height] == nums[height-1]) height--;
                        low++;
                        height--;
                    } else if (sum < target) {
                        low++;
                    } else {
                        height--;
                    }

                }
            }
        }
        return result;

    }
}
