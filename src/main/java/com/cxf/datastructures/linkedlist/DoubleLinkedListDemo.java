package com.cxf.datastructures.linkedlist;

/**
 * 双向链表
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        //测试 -- 普通添加
        doubleLinkedList.add(new DoubleNode(1, "宋江", "呼保义"));
        doubleLinkedList.add(new DoubleNode(2, "卢俊义", "玉麒麟"));
        doubleLinkedList.add(new DoubleNode(3, "吴用", "智多星"));
        doubleLinkedList.add(new DoubleNode(4, "公孙胜", "入云龙"));

        doubleLinkedList.show();

        System.out.println("-----------------------------------------");
//
//        //测试 -- 根据节点序号更新节点信息
        DoubleNode node = new DoubleNode(2, "小卢", "玉麒麟~~");
        doubleLinkedList.update(node);
        doubleLinkedList.show();
//
        System.out.println("-----------------------------------------");
//
//        //测试 -- 根据节点序号删除节点
        doubleLinkedList.delete(2);
        doubleLinkedList.show();

    }
}

/**
 * 双向链表
 */
class DoubleLinkedList {
    //初始化头节点
    private DoubleNode headNode = new DoubleNode(0, "", "");

    /**
     * 添加节点到链表尾部
     *
     * @param node
     */
    public void add(DoubleNode node) {
        DoubleNode temp = headNode;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 展示链表
     */
    public void show() {
        DoubleNode temp = headNode;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
    }

    /**
     * 根据节点序号更新节点信息
     *
     * @param node
     */
    public void update(DoubleNode node) {
        DoubleNode temp = headNode;
        if (temp.next == null) {
            System.out.println("链表为空");
            return;
        }
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
            temp.nickName = node.nickName;
        } else {
            System.out.println("未找到对应节点");
        }
    }

    /**
     * 根据节点序号删除节点
     *
     * @param no
     */
    public void delete(int no) {
        DoubleNode temp = headNode;
        if (temp.next == null) {
            System.out.println("链表为空");
            return;
        }
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
            temp.next.pre = temp;
        } else {
            System.out.println("未找到对应节点");
        }
    }
}

/**
 * 双向链表中的节点
 */
class DoubleNode {
    public int no;
    public String name;
    public String nickName;
    public DoubleNode next;
    public DoubleNode pre;

    public DoubleNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
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