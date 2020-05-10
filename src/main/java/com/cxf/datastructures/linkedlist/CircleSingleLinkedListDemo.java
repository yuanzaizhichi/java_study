package com.cxf.datastructures.linkedlist;

/**
 * 单向环形链表
 */
public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        //测试 - 初始化个数为5的链表
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.init(5);
        circleSingleLinkedList.show();

        //测试 - 个数为5的链表进行约瑟夫出圈
        System.out.println("--------------------------");
        circleSingleLinkedList.Joseph(1, 5, 2);
    }
}

/**
 * 单向环形链表
 */
class CircleSingleLinkedList {
    //头节点，指向第一个节点
    private Node2 head = null;

    /**
     * 初始化环形链表
     *
     * @param num
     */
    public void init(int num) {
        if (num < 1) {
            System.out.print("初始化错误");
            return;
        }
        //辅助节点,指向最后的节点
        Node2 curNode = null;
        for (int i = 1; i <= num; i++) {
            //创建新节点
            Node2 node = new Node2(i);
            if (i == 1) {
                head = node;
                curNode = node;
                node.setNext(node);
            } else {
                curNode.setNext(node);
                node.setNext(head);
                curNode = node;
            }
        }
    }

    /**
     * 遍历链表
     */
    public void show() {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        Node2 curNode = head;
        while (true) {
            System.out.println("节点" + curNode.getNo());
            if (curNode.getNext() == head) {
                break;
            }
            curNode = curNode.getNext();
        }
    }

    /**
     * 约瑟夫问题
     *
     * @param startNo 第几个开始
     * @param count   链表中的节点个数
     * @param nums    朝一个方向数到几的节点出圈
     */
    public void Joseph(int startNo, int count, int nums) {
        if (head == null || startNo < 1 || startNo > count) {
            System.out.println("参数有误,约瑟夫出圈失败");
            return;
        }
        //创建helper辅助节点，指向“ 以startNo节点为head的链表的最后一个节点 ”
        Node2 helper = head;
        while (true) {
            if (helper.getNext() == head) {
                break;
            }
            helper = helper.getNext();
        }
        //将helper和head移动到相应startNo的位置
        for (int i = 0; i < startNo - 1; i++) {
            head = head.getNext();
            helper = helper.getNext();
        }
        while (true) {
            if (helper == head) {
                System.out.println("最后出圈节点" + head.getNo());
                return;
            }
            for (int i = 0; i < nums - 1; i++) {
                head = head.getNext();
                helper = helper.getNext();
            }
            System.out.println("出圈节点" + head.getNo());
            head = head.getNext();
            helper.setNext(head);
        }
    }

}

/**
 * 链表节点
 */
class Node2 {
    private int no;
    private Node2 next;

    public Node2(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node2 getNext() {
        return next;
    }

    public void setNext(Node2 next) {
        this.next = next;
    }
}
