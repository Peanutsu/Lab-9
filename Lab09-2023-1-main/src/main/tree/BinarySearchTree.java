package tree;

import estrut.Tree;
import estrut.Node;

public class BinarySearchTree implements Tree {

    private Node root;

    @Override
    public boolean buscaElemento(int val) {
        return buscaElementoRecursivo(root, val);
    }

    private boolean buscaElementoRecursivo(Node node, int val) {
        if (node == null) {
            return false;
        }
        if (val == node.val) {
            return true;
        }
        if (val < node.val) {
            return buscaElementoRecursivo(node.left, val);
        } else {
            return buscaElementoRecursivo(node.right, val);
        }
    }

    @Override
    public int minimo() {
        if (root == null) {
            throw new IllegalStateException("Árvore vazia");
        }
        Node currentNode = root;
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.val;
    }

    @Override
    public int maximo() {
        if (root == null) {
            throw new IllegalStateException("Árvore vazia");
        }
        Node currentNode = root;
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode.val;
    }

    @Override
    public void insereElemento(int val) {
        root = insereElementoRecursivo(root, val);
    }

    private Node insereElementoRecursivo(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        if (val < node.val) {
            node.left = insereElementoRecursivo(node.left, val);
        } else if (val > node.val) {
            node.right = insereElementoRecursivo(node.right, val);
        }
        return node;
    }

    @Override
    public void remove(int val) {
        root = removeRecursivo(root, val);
    }

    private Node removeRecursivo(Node node, int val) {
        if (node == null) {
            return null;
        }
        if (val == node.val) {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            int menorValSubArvoreright = minimoSubArvore(node.right);
            node.val = menorValSubArvoreright;
            node.right = removeRecursivo(node.right, menorValSubArvoreright);
            return node;
        }
        if (val < node.val) {
            node.left = removeRecursivo(node.left, val);
            return node;
        }
        node.right = removeRecursivo(node.right, val);
        return node;
    }

    private int minimoSubArvore(Node node) {
        int minimo = node.val;
        while (node.left != null) {
            minimo = node.left.val;
            node = node.left;
        }
        return minimo;
    }

    @Override
    public int[] preOrdem() {
        return preOrdemRecursivo(root);
    }

    private int[] preOrdemRecursivo(Node node) {
        if (node == null) {
            return new int[0];
        }
        int[] result = new int[getSize(node)];
        preOrdemRecursivo(node, result, 0);
        return result;
    }

    private int preOrdemRecursivo(Node node, int[] result, int index) {
        if (node == null) {
            return index;
        }
        result[index++] = node.val;
        index = preOrdemRecursivo(node.left, result, index);
        index = preOrdemRecursivo(node.right, result, index);
        return index;
    }

    @Override
    public int[] emOrdem() {
        return emOrdemRecursivo(root);
    }

    private int[] emOrdemRecursivo(Node node) {
        if (node == null) {
            return new int[0];
        }
        int[] result = new int[getSize(node)];
        emOrdemRecursivo(node, result, 0);
        return result;
    }

    private int emOrdemRecursivo(Node node, int[] result, int index) {
        if (node == null) {
            return index;
        }
        index = emOrdemRecursivo(node.left, result, index);
        result[index++] = node.val;
        index = emOrdemRecursivo(node.right, result, index);
        return index;
    }

    @Override
    public int[] posOrdem() {
        return posOrdemRecursivo(root);
    }

    private int[] posOrdemRecursivo(Node node) {
        if (node == null) {
            return new int[0];
        }
        int[] result = new int[getSize(node)];
        posOrdemRecursivo(node, result, 0);
        return result;
    }

    private int posOrdemRecursivo(Node node, int[] result, int index) {
        if (node == null) {
            return index;
        }
        index = posOrdemRecursivo(node.left, result, index);
        index = posOrdemRecursivo(node.right, result, index);
        result[index++] = node.val;
        return index;
    }

    private int getSize(Node node) {
        if (node == null) {
            return 0;
        }
        return getSize(node.left) + getSize(node.right) + 1;
    }

}
