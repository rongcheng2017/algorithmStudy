package tree.bst;


import java.util.*;

/**
 * 98. Validate Binary Search Tree
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {


    /**
     * 最简单一种的算法
     *
     * @param root
     * @return
     */
    public boolean isValidBST_TreeMap(TreeNode root) {
        if (root == null)
            return true;
        ArrayList<Integer> sortList = new ArrayList<>();
        //中序遍历  如果是二叉搜索树  遍历出来的就是升序的序列
        infixoder(root, sortList);
        //二叉搜索树种不会存在一样的结点  使用TreeSet 即去重又排序
        TreeSet set = new TreeSet(sortList);
        //比较两者  确认中序遍历出来的额是否为升序序列 如果是 怎证明是二叉搜索树
        return Arrays.equals(set.toArray(), sortList.toArray());
    }

    private void infixoder(TreeNode root, ArrayList<Integer> list) {
        if (root == null)
            return;
        infixoder(root.left, list);
        list.add(root.val);
        infixoder(root.right, list);
    }


    /**
     * 左子树种最大的值小于 root值
     * 右子树种最小的值大于 root值
     *
     * @param root
     * @return
     */
    public boolean isValidBST_Recursion(TreeNode root) {
        if (root == null)
            return true;
        return isBst(root, null, null);
    }

//    private Boolean isBst(TreeNode root, long min, long max) {
//        if (root == null)
//            return true;
//        if (root.val <= min) return false;
//        if (root.val >= max) return false;
//        return isBst(root.left, min, root.val) &&
//                isBst(root.right, root.val, max);
//    }

    private Boolean isBst(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;
        if (min != null && root.val < min) return false;
        if (max != null && root.val > max) return false;
        return isBst(root.left, min, root.val) && isBst(root.right, root.val, max);
    }


    /**
     * 通过stack对上一种的非递归实现
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> s = new Stack<>();
        TreeNode currentNode = root;
        TreeNode preNode = null;
        while (true) {
            while (currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.left;
            }
            if (s.isEmpty())
                break;

            currentNode = s.pop();
            if (preNode != null && preNode.val >= currentNode.val) {
                return false;
            }
            preNode = currentNode;
            currentNode = currentNode.right;
        }
        return true;
    }


    public List readBst(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> treeNodeList = new ArrayList<>();
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty())
                break;
            treeNodeList.add(stack.pop());
            cur = cur.right;
        }
        return treeNodeList;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
