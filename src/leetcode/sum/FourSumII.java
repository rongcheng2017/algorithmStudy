package leetcode.sum;

import java.util.*;

/**
 * 454. 4Sum II
 * <p>
 * HashMap
 * <p>
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * <p>
 * Note:
 * <p>
 * o make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 * All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 */
public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        if (A == null || B == null || C == null || D == null)
            return res;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i2 : C) {
            for (int i1 : D) {
                map.put(i2 + i1, map.getOrDefault(i2 + i1, 0) + 1);
            }
        }
        for (int i1 : A) {
            for (int i : B) {
                res += map.getOrDefault(-1 * (i1 + i), 0);
            }
        }
        return res;
    }
}
