package com.cxf.leetcode.array.p_4_2dimensionalarrandscrollingarr;

import java.util.ArrayList;
import java.util.List;

public class Q_119 {
    public static void main(String[] args) {
        System.out.println(getRow3(3));
    }

    /**
     * 解法: 平民解法
     * 时间复杂度: T(n) = O(n²)
     * 空间复杂度: S(n) = O(n)
     */
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> lstYangHui = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> lstSub = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    lstSub.add(1);
                } else {
                    lstSub.add(lstYangHui.get(i - 1).get(j - 1) + lstYangHui.get(i - 1).get(j));
                }
            }
            lstYangHui.add(lstSub);
        }
        return lstYangHui.get(rowIndex);
    }

    /**
     * 解法: 平民解法优化1滚动数组
     * 时间复杂度: T(n) = O(n²)
     * 空间复杂度: S(n) = O(n)
     */
    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> lstPre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> lstSub = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    lstSub.add(1);
                } else {
                    lstSub.add(lstPre.get(j - 1) + lstPre.get(j));
                }
            }
            lstPre = lstSub;
        }
        return lstPre;
    }

    /**
     * 解法: 平民解法优化2：使用一个数组不断进行更新
     * 时间复杂度: T(n) = O(n²)
     * 空间复杂度: S(n) = O(1)
     */
    public static List<Integer> getRow3(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}
