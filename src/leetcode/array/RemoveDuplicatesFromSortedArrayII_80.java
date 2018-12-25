package leetcode.array;


/**
 * 80. Remove Duplicates from Sorted Array II
 * <p>
 * <p>
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * notice : at most twice 最多显示两次 显示超过两次的去掉
 * 26. Remove Duplicates from Sorted Array的升级
 */
public class RemoveDuplicatesFromSortedArrayII_80 {

    public static void main(String[] args) {
        int[] data = {1, 1, 1, 2, 2, 3};

        for (int i = 0; i < removeDuplicates(data); i++) {
            System.out.println(data[i]);
        }
    }

    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 1;
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                if (count <= 0)
                    j++;
                else {
                    count--;
                    nums[++i] = nums[j++];
                }
            } else {
                count = 1;
                nums[++i] = nums[j++];
            }
        }
        return i + 1;
    }
}