package tree;

public class AVLBTree<E extends Comparable> {
    BiTNode<E> root;
    //平衡因子
    private final int LH = 1;
    private final int eH = 0;
    private final int RH = -1;

    /**
     * @param t 平衡因子大于1的不平衡树的根节点
     */
    public void leftBalance(BiTNode<E> t) {

        BiTNode L = t.childLeft;
        switch (L.balance_factor) {
            case LH://新插入的孩子在L的左边， L的平衡因子和其父节点平衡因子都是正的 所以只需要一次右旋即可
                L.balance_factor = eH;
                t.balance_factor = eH;
                rightRotate(t);
                break;
            case RH://新插入的节点在t的左孩子的右子树上 需要双旋转处理
                


                break;

        }
    }

    public void rightRotate(BiTNode<E> p) {
        if (p == null)
            return;

        //将P的左子的右孩子的parent指向p
        BiTNode pL = p.childLeft;
        if (pL.childRight != null) {
            p.childLeft = pL.childRight;
            pL.childRight.parent = p;
        }
        pL.parent = p.parent;
        if (p.parent == null) {
            root = pL;
        } else if (p.parent.childRight == p) {
            p.parent.childRight = pL;
        } else if (p.parent.childLeft == p) {
            p.parent.childLeft = pL;
        }
        pL.childRight = p;
        p.parent = pL;

    }

    public void leftRotate(BiTNode<E> p) {
        if (p == null)
            return;
        BiTNode pR = p.childRight;
        if (pR.childLeft != null) {
            p.childRight = pR.childLeft;
            pR.childLeft.parent = p;
        }

        pR.parent = p.parent;
        if (p.parent == null)
            root = pR;
        else if (p.parent.childRight == p)
            p.parent.childRight = pR;
        else if (p.parent.childLeft == p)
            p.parent.childLeft = pR;

        pR.childRight = p;
        p.parent = pR;
    }


    class BiTNode<E extends Comparable> {
        private E element;
        //平衡因子
        private int balance_factor = 0;
        private BiTNode<E> childLeft;
        private BiTNode<E> childRight;
        private BiTNode<E> parent;

        public BiTNode() {
        }

        public BiTNode(E element, BiTNode<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public int getBalance_factor() {
            return balance_factor;
        }

        public void setBalance_factor(int balance_factor) {
            this.balance_factor = balance_factor;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public BiTNode<E> getChildLeft() {
            return childLeft;
        }

        public void setChildLeft(BiTNode<E> childLeft) {
            this.childLeft = childLeft;
        }

        public BiTNode<E> getChildRight() {
            return childRight;
        }

        public void setChildRight(BiTNode<E> childRight) {
            this.childRight = childRight;
        }

        public BiTNode<E> getParent() {
            return parent;
        }

        public void setParent(BiTNode<E> parent) {
            this.parent = parent;
        }
    }
}
