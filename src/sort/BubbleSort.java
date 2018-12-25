package sort;


/**
 * 冒泡排序
 */

public class BubbleSort {
    //TODO 冒泡排序


    public static int main(String[] args) {
        return 0;
    }

    int main() {
        int[] reslution = bubble(new int[]{3, 2, 1, 4, 7, 5, 7, 8, 9});
        for (int i : reslution) {
            System.out.println("" + i);
        }
        return 0;
    }

    private int[] bubble(int[] array) {
        if (array == null || array.length == 0)
            return null;

        if (array.length == 1)
            return array;

        for (int j = 0; j < array.length - 2; j++) {
            for (int i = j; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                }
            }
        }

        return array;

    }
}
