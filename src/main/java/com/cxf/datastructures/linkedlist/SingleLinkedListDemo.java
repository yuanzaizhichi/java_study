package com.cxf.datastructures.linkedlist;

/**
 * 单链表
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //测试 -- 普通添加
//        singleLinkedList.add(new Node(1, "宋江", "呼保义"));
//        singleLinkedList.add(new Node(2, "卢俊义", "玉麒麟"));
//        singleLinkedList.add(new Node(3, "吴用", "智多星"));
//        singleLinkedList.add(new Node(4, "公孙胜", "入云龙"));

        //测试 -- 按节点序号添加至链表
        singleLinkedList.addByNodeNo(new Node(1, "宋江", "呼保义"));
        singleLinkedList.addByNodeNo(new Node(4, "公孙胜", "入云龙"));
        singleLinkedList.addByNodeNo(new Node(3, "吴用", "智多星"));
        singleLinkedList.addByNodeNo(new Node(2, "卢俊义", "玉麒麟"));
        singleLinkedList.show();

        System.out.println("-----------------------------------------");

        //测试 -- 根据节点序号更新节点信息
        Node node = new Node(2, "小卢", "玉麒麟~~");
        singleLinkedList.update(node);
        singleLinkedList.show();

        System.out.println("-----------------------------------------");

        //测试 -- 根据节点序号删除节点
        singleLinkedList.delete(1);
        singleLinkedList.show();


    }
}

/**
 * 单链表
 */
class SingleLinkedList {
    //初始化头节点
    private Node headNode = new Node(0, "", "");

    /**
     * 添加节点到链表尾部
     *
     * @param node
     */
    public void add(Node node) {
        Node temp = headNode;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 按节点序号添加至链表
     *
     * @param node
     */
    public void addByNodeNo(Node node) {
        Node temp = headNode;
        //flag : 添加的节点是否已存在
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.no == node.no) {
                flag = true;
            }
            if (temp.next.no > node.no) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("需要添加的节点在链表中已存在");
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * 展示链表
     */
    public void show() {
        Node temp = headNode;
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
    public void update(Node node) {
        Node temp = headNode;
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
        Node temp = headNode;
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
        } else {
            System.out.println("未找到对应节点");
        }
    }
}

/**
 * 链表中的节点
 */
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

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}