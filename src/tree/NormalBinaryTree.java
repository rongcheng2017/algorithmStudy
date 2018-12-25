package tree;

public class NormalBinaryTree<D> {
    Node<D> root;

    public NormalBinaryTree(D d) {
        this.root = new Node<D>(d, null, null);
    }


    class Node<D> {
        D data;
        Node<D> liftChild;
        Node<D> rightChild;

        public Node(D data, Node<D> liftChild, Node<D> rightChilfd) {
            this.data = data;
            this.liftChild = liftChild;
            this.rightChild = rightChilfd;
        }
    }




    /**
     * @param root
     */
    public void midOrderTravere(Node root) {
        if (root == null)
            return;

        midOrderTravere(root.liftChild);
        System.out.println("mid: " + root.data);
        midOrderTravere(root.rightChild);
    }

    /**
     * DLR
     *
     * @param root
     */
    public void preOrderTravere(Node root) {
        if (root == null)
            return;
        System.out.println("pre: " + root.data);
        midOrderTravere(root.liftChild);
        midOrderTravere(root.rightChild);
    }

    /**
     * LRD
     *
     * @param root
     */
    public void endOrderTravere(Node root) {
        if (root == null)
            return;
        midOrderTravere(root.liftChild);
        midOrderTravere(root.rightChild);
        System.out.println("pre: " + root.data);

    }


}
