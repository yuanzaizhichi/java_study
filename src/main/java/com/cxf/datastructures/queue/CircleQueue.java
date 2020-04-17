package com.cxf.datastructures.queue;

import java.util.Scanner;

/**
 * 数组模拟"环形队列"
 */
public class CircleQueue {
    //数组最大容量
    private int maxSize;
    //队列头,指向头数据,初始值为0
    private int front;
    //队列尾，指向尾数据的后一个位置,初始值为0
    private int rear;
    //数据数组
    private int[] arr;

    public static void main(String[] args) {
        CircleQueue arrayQueue = new CircleQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        char key = ' ';
        while (flag) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):入队");
            System.out.println("g(get):出队");
            System.out.println("h(head):查看队列头的数据");

            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    try {
                        arrayQueue.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int num = scanner.nextInt();
                    arrayQueue.add(num);
                    break;
                case 'g':
                    try {
                        int value = arrayQueue.get();
                        System.out.println("出队的数据是" + value);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int value = arrayQueue.headQueue();
                        System.out.println("当前头数据为" + value);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'e':
                    System.out.println("退出程序");
                    flag = false;
                default:
                    break;
            }
        }

    }

    public CircleQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据（入队列）
    public void add(int n) {
        if (isFull()) {
            System.out.println("队列已满，无法添加数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //取出数据（出队列）
    public int get() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空，无法取出数据");
        }
        front++;
        return arr[front];
    }

    //显示队列所有数据
    public void show() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //查看队列头数据
    public int headQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空，无法查看头数据");
        }
        return arr[front + 1];
    }
}
