package com.cxf.datastructures.sparsearray;

/**
 * 稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) {
        //创建一个原始的二维数组 11 * 11
        //0表示没有棋子；1表示黑棋子；2表示蓝旗子
        int[][] chessArray1 = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        chessArray1[3][4] = 3;
        System.out.println("遍历原始二维数组:");
        for (int[] row : chessArray1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println();

        //原始二维数组转换为稀疏数组
        //计算不同值的数量
        int sum = 0;
        for (int[] row : chessArray1) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //记录数组共有几行几列，有多少个不同的值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //用于记录当前第几个非0值
        int count = 0;
        //储存非0值信息
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArray1[i][j];
                }
            }

        }
        System.out.println("遍历稀疏数组:");
        for (int[] data : sparseArr) {
            System.out.printf("%d\t%d\t%d\t\n", data[0], data[1], data[2]);
        }
        System.out.println();

        //稀疏数组转换原始二维数组
        //原始数组行数
        int row = sparseArr[0][0];
        //原始数组列数
        int col = sparseArr[0][1];
        //原始数组不同值数量
        int dataSum = sparseArr[0][2];
        //创建原始数组
        int[][] chessArray2 = new int[row][col];
        //重构原始数组
        for (int i = 1; i <= dataSum; i++) {
            int dataRow = sparseArr[i][0];
            int dataCol = sparseArr[i][1];
            int data = sparseArr[i][2];
            chessArray2[dataRow][dataCol] = data;
        }
        System.out.println("遍历由稀疏数组转换得到的原始二维数组:");
        for (int[] row2 : chessArray2) {
            for (int data2 : row2) {
                System.out.printf("%d\t", data2);
            }
            System.out.println();
        }
    }
}
