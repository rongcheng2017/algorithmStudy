package leetcode.sum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

    /**
     * 子数组求和 一定要想到  array  of  prefixSum 即   target = sum of array(i,j)= prefixSum[j]-prefixSum[i-1]
     */
    public static void main(String[] args) {
        int[] testData = {1, 1, 1};
        System.out.println("result is :" + subArraySum2(testData, 2));

    }

    /**
     * 560. Subarray Sum Equals K
     * <p>
     *
     * <p>
     * Given an array of integers and an integer k,
     * you need to find the total number of continuous subarrays whose sum equals to k.
     * <p>
     * 考点：数组 Array, 哈希表 Hash Table, Prefix Sum
     * * 难度：中等
     *
     * @param nums
     * @param target
     * @return
     */
    private static int subarraySum(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - target))
                count += map.get(sum - target);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    /**
     * Naive Solution
     * <p>
     * idea: for each subarray(i,j);check if the sum of subarray(i,j) == k
     * <p>
     * time O(n*n*n)
     * space O(1)
     * Time Limit Exceeded
     */
    private static int subArraySum3(int[] nums, int k) {
        if (nums == null || nums.length <= 0)
            return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int index = i; index <= j; index++)
                    sum += nums[index];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    /**
     * Better Solution
     * <p>
     * Identify the repeated computation -->  Prefix Sum
     * </p>
     * time O(n*n)
     * space O(1)
     * timeout
     */
    private static int subArraySum2(int[] nums, int k) {
        if (nums == null || nums.length <= 0)
            return 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int prefixSum = 0;
            for (int j = i; j < nums.length; j++) {
                prefixSum += nums[j];
                if (prefixSum == k)
                    count++;
            }
        }
        return count;
    }


    /**
     * Linear Solution
     * <p>
     * Utilizing the prefixSum array of the original input.
     * prefixSum[x]= sum of subarray(0,x) = nums[0]+nums[1]+.....nums[x]
     * sum of subarray(i,j) = prefixSum[j] - prefixSum[i-1]
     * </p>
     * <p>
     * idea:
     * Find how many pairs of <i,j>
     * where i<j, prefixSum[j]-prefixSum[i]==k?
     * <p>
     * time O(n)
     * space O(n)
     * <p>
     * 将prefixSum作为key，出现次数作为value存储在Map中，
     * 如果 prefixSum[i] = prefixSum[j] - target 则 ==》target =prefixSum[j] - prefixSum[i]
     * --> target = nums(i,j)
     * 并且prefixSum如果在Map中存在，那么肯定存在
     * <p>
     * <p>
     * Map中存储的是 sum是几的出现过几次   <0,1>==> sum=0的出现了1次
     */
    private static int subArraySum1(int[] nums, int target) {
        if (nums == null || nums.length <= 0)
            return 0;

        Map<Integer, Integer> sums = new HashMap<>();
        int count = 0;
        int prefixSum = 0;
        sums.put(0, 1);
        for (int num : nums) {
            prefixSum += num;
            count += sums.getOrDefault(prefixSum - target, 0);
            sums.put(prefixSum, sums.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }


}
