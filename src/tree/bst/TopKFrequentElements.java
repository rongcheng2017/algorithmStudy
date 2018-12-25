package tree.bst;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 * Given a non-empty array of integers, return the k most frequent elements.
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        for (Integer integer : topKFrequent(nums, 2)) {
            System.out.println(integer);
        }
    }

    private static List<Integer> topKFrequent(int[] nums, int k) {
        if (k <= 0 || nums == null || nums.length == 0)
            return null;

        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue((Comparator<Map.Entry<Integer, Integer>>) (o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            priorityQueue.add(integerIntegerEntry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }

        }
        ArrayList result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll().getKey());
        }

        return result;

    }
}
