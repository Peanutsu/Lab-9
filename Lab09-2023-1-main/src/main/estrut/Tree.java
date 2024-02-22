package estrut;

public interface Tree extends EstruturaElementar{
    public int[] preOrdem();
    public int[] emOrdem();
    public int[] posOrdem();
    private int height(Node node) {
        if (node == null)
            return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
}
private int preOrdem(Node node, int[] result, int index) {
    if (node == null) {
        return index;
    }
    result[index++] = node.val;
    index = preOrdem(node.left, result, index);
    index = preOrdem(node.right, result, index);
    return index;
}
}