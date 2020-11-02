package com.cxf.datastructures.binarytree;

/**
 * 排序二叉树
 */
public class BinarySortTree {

    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree();
        binarySortTree.add(3);
        binarySortTree.add(1);
        binarySortTree.add(6);
        binarySortTree.add(5);
        binarySortTree.add(2);
        binarySortTree.add(9);
        binarySortTree.add(7);
        binarySortTree.travel(binarySortTree.root);
    }

    private Node root;

    /**
     * 中序遍历
     *
     * @param node
     */
    private void travel(Node node) {
        if (node == null) {
            return;
        }
        travel(node.left);
        System.out.println(node.data + " ");
        travel(node.right);
    }

    /**
     * 添加节点
     *
     * @param data
     */
    private void add(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        while (true) {
            if (current.data > data) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            }
        }
    }


}

class Node {
    int data;
    Node left;
    Node right;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }
}
