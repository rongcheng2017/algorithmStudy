package leetcode.array;

/**
 * 26. Remove Duplicates from Sorted Array
 * <p>
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * <p>
 * note: space O(1)  sorted
 */


/**
 * 解题思路  双指针
 */
public class RemoveDuplicatesFromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                nums[j] = nums[i];
            } else {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public int removeDuplicates3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[++i] = nums[j++];
            }
        }
        return i + 1;
    }


}
