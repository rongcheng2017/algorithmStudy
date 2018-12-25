package leetcode.sum;

/*****************************   653. Two Sum IV - Input is a BST*********************/

import java.util.*;

/**
 * Given a Binary Search Tree and a target number,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 * <p>
 * <p>
 * idea : 读取BST中所有数据，然后按照twoSum的思想就能解决
 */
public class TwoSumIV {


    public static void main(String[] args) {


    }

    /**
     * 根据二叉搜索树的特征，用中序遍历出从小到大排序的所以数据，然后通过left->  <-right 的方法找到合适的两个数据
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> result = new ArrayList<>();
        BstTList(root, result);
        int left = 0;
        int right = result.size() - 1;
        while (left < right) {
            int sum = result.get(left) + result.get(right);
            if (sum == k)
                return true;
            if (sum < k)
                left++;
            else right--;
        }
        return false;
    }


    private static void BstTList(TreeNode treeNode, List<Integer> result) {
        if (treeNode == null)
            return;
        BstTList(treeNode.left, result);
        result.add(treeNode.val);
        BstTList(treeNode.right, result);

    }

    /**
     * 和普通twoSum解法差不多  只是查找对象方式不同
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget1(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    private boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);

    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

}

