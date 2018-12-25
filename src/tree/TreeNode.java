package tree;

public class TreeNode implements Comparable<Integer> {

    private TreeNode childLeft;
    private TreeNode childRight;
    private int data;

    public TreeNode(TreeNode childLeft, TreeNode childRight, int data) {
        this.childLeft = childLeft;
        this.childRight = childRight;
        this.data = data;
    }

    public TreeNode getChildLeft() {
        return childLeft;
    }

    public void setChildLeft(TreeNode childLeft) {
        this.childLeft = childLeft;
    }

    public TreeNode getChildRight() {
        return childRight;
    }

    public void setChildRight(TreeNode childRight) {
        this.childRight = childRight;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }


    @Override
    public int compareTo(Integer o) {
        return data-o;
    }
}
