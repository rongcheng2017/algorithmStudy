package leetcode.sum;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> resultSet = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int complement = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == complement) {
                    List<Integer> tempList = new ArrayList<>(3);
                    tempList.add(nums[i]);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);
                    resultSet.add(tempList);
                    left++;
                    right--;
                } else if (sum < complement)
                    left++;
                else right--;

            }
        }
        return new ArrayList<>(resultSet);

    }

    /**
     * 没有使用set来去重 自己实现去重逻辑 速度提升很多
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        if (nums.length < 3)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])//因为已经排过序 所以相同的数肯定相邻 因此去掉相邻相同的就去掉所以相同的了
                continue;
            int complement = -nums[i];
            int left = i + 1;
            int right = nums.length - 2;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == complement) {
                    List<Integer> tempList = new ArrayList<>(3);
                    tempList.add(nums[i]);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);
                    resultList.add(tempList);
                    left++;
                    right--;
                    //相同的数直接pass
                    while (left < right && left > 0 && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && right < nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < complement)
                    left++;
                else right--;
            }
        }
        return resultList;

    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return resultList;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])//因为已经排过序 所以相同的数肯定相邻 因此去掉相邻相同的就去掉所以相同的了
                continue;
            int complement = -nums[i],
                    left = i + 1,
                    right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == complement) {
                    List<Integer> tempList = new ArrayList<>(3);
                    tempList.add(nums[i]);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);
                    resultList.add(tempList);
                    left++;
                    right--;
                    //相同的数直接pass
                    while (left < right && left > 0 && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && right < nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < complement)
                    left++;
                else right--;
            }
        }
        return resultList;

    }

}
