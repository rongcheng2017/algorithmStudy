package tree.bst;

import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream
 * <p>
 * <p>
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 */


/**
 * 用java自带优先队列PriorityQueue(小顶堆)的结构体来解决
 */

public class KthLargest {
    PriorityQueue<Integer> priorityQueue;
    private int k;

    public void KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue(k);
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    private int add(int val) {
        if (priorityQueue.size() < k) {
            priorityQueue.add(val);
        } else if (val > priorityQueue.peek()) {
            priorityQueue.poll();
            priorityQueue.add(val);
        }
        return priorityQueue.peek();
    }
}
