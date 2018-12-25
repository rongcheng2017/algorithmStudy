import tree.HeapSort;

public class Test {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 4, 9, 56, 90};
        int[] result=twoSum1(array,8);
        for (int i : result) {
            System.out.println("  :: " + i);
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 0)
            throw new IllegalArgumentException("numbers can not be null");
        int low = 0;
        int height = numbers.length - 1;
        int[] result = new int[2];
        while (low < height) {
            int sum = numbers[low] + numbers[height];
            if (sum == target) {
                result[0] = low;
                result[1] = height;
                return result;
            } else if (sum < target)
                low++;
            else height--;
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum1(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 0)
            throw new IllegalArgumentException("numbers can not be null");

        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1;
            int height = numbers.length - 1;
            int[] result = new int[2];
            while (low <= height) {
                int mid = (low + height)>>1;
                int sum = numbers[mid] + numbers[i];
                if (sum == target) {
                    result[0] = i;
                    result[1] = mid;
                    return result;
                } else if (sum < target)
                    low=mid+1;
                else
                    height=mid-1;
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

}
