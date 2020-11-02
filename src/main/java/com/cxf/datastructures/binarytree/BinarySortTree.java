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
//        binarySortTree.travel(binarySortTree.root);
        System.out.println(binarySortTree.findNodeParent(8).data);

//        Node node = binarySortTree.findNode(5);
//        System.out.println("---------");
//        System.out.println(node.data);
//        System.out.println(node.left.data);
//        System.out.println(node.right.data);
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

    /**
     * 寻找某个节点
     *
     * @param value
     * @return
     */
    private Node findNode(int value) {
        Node current = root;
        while (true) {
            if (current == null) {
                return null;
            }
            if (current.data == value) {
                return current;
            }
            if (current.data > value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }

    /**
     * 寻找某个节点的父节点
     *
     * @param value
     * @return
     */
    private Node findNodeParent(int value) {
        if (root == null) {
            return null;
        }
        if (root.data == value) {
            return null;
        }
        Node current = root;
        while (true) {
            if (current == null) {
                return null;
            }
            if (current.data > value) {
                if (current.left == null) {
                    return null;
                }
                if (current.left.data == value) {
                    return current;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    return null;
                }
                if (current.right.data == value) {
                    return current;
                }
                current = current.right;
            }
        }
    }

    private Node findFinalLeft(Node node) {

    }

    /**
     * 删除某个节点(三种情况)
     *
     * @param value
     * @return
     */
    private Node del(int value) {
        //空树
        if (root == null) {
            return null;
        }
        Node target = findNode(value);
        Node targetParent = findNodeParent(value);
        if (target == null) {
            return null;
        } else {
            //找到了待删除节点
            //情况1:待删除节点没有左右子树 -> 直接删除
            if (target.left == null && target.right == null) {
                if (targetParent == null) {
                    //表示没有子树和父节点，整棵树只有待删除节点一个节点，直接置空
                    root = null;
                    return target;
                } else {
                    //有父节点，但有可能是该父节点的左或右子节点
                    if (targetParent.left == null) {
                        targetParent.right = null;
                        return target;
                    } else {
                        targetParent.left = null;
                        return target;
                    }
                }

            } else if (target.left == null || target.right == null) {
                //情况2:待删除节点有左子树或者右子树 -> 删除待删除节点，将待删除节点的左子树或右子树嫁接到它的父节点
                if (target.left == null) {
                    if (targetParent == null) {
                        root = target.right;
                        return target;
                    }
                    if (targetParent.left != null && target.left.data == value) {
                        targetParent.left = target.right;
                        return target;
                    } else {
                        targetParent.right = target.right;
                        return target;
                    }
                } else {
                    if (targetParent == null) {
                        root = target.left;
                        return target;
                    }
                    if (targetParent.left != null && target.left.data == value) {
                        targetParent.left = target.left;
                        return target;
                    } else {
                        targetParent.right = target.left;
                        return target;
                    }
                }
            } else {
                //情况3:待删除节点既有左子树又有右子树

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
