package estrut;

public class Node {

    public int val;
    public Node left;
    public Node right;
    
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
    Node root = null;
}