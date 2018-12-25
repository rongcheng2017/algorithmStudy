package tree;



/**
 * 堆排序
 * <p>
 * 利用大顶堆进行
 */
public class HeapSort {


    public void sort(int[] array) {
        //先将数组构成一个大顶堆
        int i = array.length / 2;
        for (; i >=0; i--) {
            HeapAdjust(array, i, array.length-1);
        }
        for (i = array.length-1; i > 0; i--) {
            FUtilKt.swap(array, 0, i);
            HeapAdjust(array, 0, i-1 );
        }
    }

    /**
     * 堆调准
     *
     * @param array  序列数组
     * @param mid    当前范围内树根的位置  完全二叉树 mid=length/2
     * @param length 长度
     */
    private void HeapAdjust(int[]array, int mid, int length) {
        int temp, j;
        temp = array[mid];
        for (j = 2 * mid; j <=length; j *= 2) {//mid位置的左子位置角标是2*mid，
            if (j < length && array[j] < array[j + 1]) {//不是最后一个数组并且比右子要小 那么就取右的角标
                ++j;
            }
            if (temp >= array[j]) {
                break; //如果 mid的两个子都小于mid 直接return
            }
            array[mid]=array[j];//如果mid的子中存在比他大的 那么将其值付给mid处
            mid = j;
        }
        array[mid]=temp;//将mid位置的值于他子中最大的那个数互换

    }
}
