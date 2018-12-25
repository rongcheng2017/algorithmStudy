package leetcode.array;


/**
 * Remove Element
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * <p>
 * note :空间复杂度为O(1) 不允许新创建数组
 * 返回移除后的长度 并能去除前length个数 顺序无要求
 */


/**
 * 解题思路： 不能创建新的存储单位，又要能前length能输出结果，且java中数组没有remove功能
 * 1.要替换位置 将非val的值排在数组前面
 * 2、使用指针限定数组取值范围
 */
public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public int removeElement2(int[] nums, int val) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            if (nums[start] == val) {

                nums[start] = nums[end - 1];
                end--;
            } else {
                start++;
            }
        }
        return start;
    }
}
