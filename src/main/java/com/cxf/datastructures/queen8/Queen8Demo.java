package com.cxf.datastructures.queen8;

/**
 * 八皇后问题
 */
public class Queen8Demo {
    private int maxSize = 8;
    int[] queenArray = new int[maxSize];

    public static void main(String[] args) {
        Queen8Demo queen8Demo = new Queen8Demo();
        queen8Demo.put(0);
    }

    /**
     * 放置皇后的方法
     * @param n
     */
    public void put(int n){
        if (n == maxSize){
            show();
            return;
        }

        for (int i = 0; i < maxSize; i++) {
            queenArray[n] = i;
            if (check(n)){
                put(n + 1);
            }
        }
    }

    /**
     * 检测当前放置的皇后与之前放置皇后位置是否冲突
     * @param n 第几个皇后
     * @return
     */
    public boolean check(int n){
        for (int i = 0; i < n; i++) {
            if (queenArray[i] == queenArray[n] || Math.abs(i - n) == Math.abs(queenArray[i] - queenArray[n])){
                return false;
            }
        }
        return true;
    }

    //遍历放置皇后的数组
    public void show(){
        for (int i = 0; i < maxSize; i++) {
            System.out.print(queenArray[i] + " ");
        }
        System.out.println();
    }
}
