package com.cxf.algorithm.queen8;

/**
 * 八皇后问题
 *
 * @author cxf
 */
public class Queen8Demo {
    /**
     * 皇后数量
     */
    private final int maxSize = 8;
    /**
     * 定义数组表示放置皇后的方式
     * 下标i(0~7)表示8个皇后分别放置在1~8行
     * queenArray[i]表示每个皇后在本行的第几列
     */
    int[] queenArray = new int[maxSize];

    public static void main(String[] args) {
        Queen8Demo queen8Demo = new Queen8Demo();
        //从第1行开始放置皇后
        queen8Demo.put(0);
    }

    /**
     * 放置皇后的方法
     * 触发递归回溯：在put方法中的两个回溯
     * 递归回溯的问题本质上就是：递归进入下一层后，如果发现不满足条件，就通过 return 等方式回溯到上一层递归，继续寻求合适的解。
     *
     * @param n 皇后数组下标，即第几行
     */
    public void put(int n) {
        //8个皇后放置成功，进行结果打印，并回溯到上一层递归，继续寻求合适的放置方式（回溯1）
        if (n == maxSize) {
            show();
            return;
        }

        //在该行选择列放置皇后
        //放置成功：进入下一层递归，放置下一个皇后
        //放置不成功：for循环走完，将回溯到上一层递归，更换上一个皇后位置，继续判断（回溯2）
        for (int i = 0; i < maxSize; i++) {
            queenArray[n] = i;
            if (check(n)) {
                put(n + 1);
            }
        }
    }

    /**
     * 检测当前放置的皇后与之前放置皇后位置是否冲突
     *
     * @param n 第几个皇后
     * @return true：可放置；false：与之前放置的皇后冲突，不可放置
     */
    public boolean check(int n) {
        for (int i = 0; i < n; i++) {
            if (queenArray[i] == queenArray[n] || Math.abs(i - n) == Math.abs(queenArray[i] - queenArray[n])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 遍历放置皇后的数组
     */
    public void show() {
        for (int i = 0; i < maxSize; i++) {
            System.out.print(queenArray[i] + " ");
        }
        System.out.println();
    }
}
