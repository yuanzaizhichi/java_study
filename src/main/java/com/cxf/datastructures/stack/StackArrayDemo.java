package com.cxf.datastructures.stack;

public class StackArrayDemo {
    public static void main(String[] args) {
        StackArray stackArray = new StackArray(3);
        stackArray.push(1);
        stackArray.push(2);
        stackArray.push(3);
        stackArray.push(4);
        stackArray.show();
        stackArray.pop();
        stackArray.pop();
        stackArray.push(4);
        stackArray.push(5);
        stackArray.show();
    }
}

class StackArray {
    //存放数据的数组
    private int[] stack;
    //栈顶
    private int top = -1;
    //栈大小
    private int maxSum = 0;

    //构建器
    public StackArray(int maxSum) {
        this.maxSum = maxSum;
        stack = new int[this.maxSum];
    }

    //栈满
    public boolean isFull() {
        return top == maxSum - 1;
    }

    //栈空
    public boolean isEmtry() {
        return top == -1;
    }

    //入栈
    public void push(int num) {
        if (isFull()) {
            System.out.println("栈满，无法入栈!");
            return;
        }
        top++;
        stack[top] = num;
    }

    //出栈
    public int pop() {
        if (isEmtry()) {
            throw new RuntimeException("栈空，无法出栈!");
        }
        int result = stack[top];
        top--;
        return result;
    }

    //遍历栈
    public void show() {
        if (isEmtry()) {
            throw new RuntimeException("栈空!");
        }
        for (int i = 0; i <= top; i++) {
            System.out.println(stack[i]);
        }
    }
}
