public class FUtil {

    public static  void swap(int[] array, int a, int b) {
        if (a >= array.length || a < 0) {
            throw new ArrayIndexOutOfBoundsException("first param a out of index");
        }

        if (b >= array.length || b < 0) {
            throw new ArrayIndexOutOfBoundsException("second param a out of index");
        }
        if (a == b) {
            return;
        }
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
