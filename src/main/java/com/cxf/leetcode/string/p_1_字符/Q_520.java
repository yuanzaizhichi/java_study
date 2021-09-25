package com.cxf.leetcode.string.p_1_字符;

public class Q_520 {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
    }

    /**
     * 解法: 简单
     * 时间复杂度: T(n) = O(n)
     * 空间复杂度: S(n) = O(1)
     */
    public static boolean detectCapitalUse(String word) {
        int l = word.length();
        int z = 0;
        for (int i = 0; i < l; i++) {
            if (word.charAt(i) >= 65 && word.charAt(i) <= 90) z++;
        }
        if (z == l || (word.charAt(0) >= 65 && word.charAt(0) <= 90 && z == 1) || z == 0) return true;
        return false;
    }
}
