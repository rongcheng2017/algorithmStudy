package tree.bst;

import java.util.*;

/**
 * 692. Top K Frequent Words
 * Given a non-empty list of words, return the k most frequent elements.
 * <p>
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 */
public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] nums = {"i", "love", "leetcode", "i", "love", "coding"};
        for (String integer : topKFrequent(nums, 1)) {
            System.out.println(integer);
        }
    }

    public static List<String> topKFrequent(String[] words, int k) {
        if (k <= 0 || words == null || words.length == 0)
            return null;

        HashMap<String, Integer> map = new HashMap();
        for (String num : words) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //小顶堆

        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().equals(o2.getValue()) ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue();

            }
        });
        for (Map.Entry<String, Integer> integerIntegerEntry : map.entrySet()) {
            priorityQueue.add(integerIntegerEntry);
            if (priorityQueue.size() >k) {
                priorityQueue.poll();
            }
        }
        LinkedList result = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            result.addFirst(priorityQueue.poll().getKey());
        }

        return result;
    }
}
