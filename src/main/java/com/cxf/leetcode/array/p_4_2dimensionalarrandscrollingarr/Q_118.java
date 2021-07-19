package com.cxf.leetcode.array.p_4_2dimensionalarrandscrollingarr;

import java.util.ArrayList;
import java.util.List;

public class Q_118 {
    public static void main(String[] args) throws Exception {
        List<List<Integer>> generate = generate(5);
        System.out.println(generate);
    }

    /**
     * 解法: 按规律遍历
     * 时间复杂度: T(n) = O(n²)
     * 空间复杂度: S(n) = O(n)
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lstRes = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> lstSub = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    lstSub.add(1);
                } else {
                    lstSub.add(lstRes.get(i - 1).get(j - 1) + lstRes.get(i - 1).get(j));
                }
            }
            lstRes.add(lstSub);
        }
        return lstRes;
    }
}
