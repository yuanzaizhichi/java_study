package com.cxf.leetcode.array.p_4_2dimensionalarrandscrollingarr;

public class Q_419 {
    public static void main(String[] args) throws Exception {
        char[][] board = new char[3][4];
        board[0] = new char[]{'.', '.', '.', 'X'};
        board[1] = new char[]{'.', '.', '.', 'X'};
        board[2] = new char[]{'.', '.', '.', 'X'};
        System.out.println(countBattleships(board));
    }

    /**
     * 解法: 标记法
     * 根据题意，遍历，找到一个X时，遍历当前位置行和列，将该船船体全部标记为O找到整艘船，接着下一个
     * 时间复杂度: T(n) = O(n)
     * 空间复杂度: S(n) = O(1)
     */
    public static int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    board = getBattleBoard(board, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static char[][] getBattleBoard(char[][] board, int i, int j) {
        board[i][j] = 'O';
        for (int column = j + 1; column < board[i].length; column++) {
            if (board[i][column] == 'X') {
                board[i][column] = 'O';
            } else {
                break;//断了，不必再循环
            }
        }

        for (int row = i + 1; row < board.length; row++) {
            if (board[row][j] == 'X') {
                board[row][j] = 'O';
            } else {
                break;
            }
        }
        return board;
    }
}
