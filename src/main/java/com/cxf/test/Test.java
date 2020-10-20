package com.cxf.test;

public class Test {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        Node node = reverseList2(node1);

        int a = 1;

    }

    //用递归的方法反转链表
    public static Node reverseList2(Node head) {
        // 1.递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
        // 递归反转 子链表
        Node newList = reverseList2(head.next);
        // 改变 1，2节点的指向。
        // 通过 head.next获取节点2
        Node t1 = head.next;
        // 让 2 的 next 指向 2
        t1.next = head;
        // 1 的 next 指向 null.
        head.next = null;
        // 把调整之后的链表返回。
        return newList;

    }

}

class Node {
    public int no;
    public String name;
    public String nickName;
    public Node next;

    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public Node(int no) {
        this.no = no;
    }

    public Node() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
