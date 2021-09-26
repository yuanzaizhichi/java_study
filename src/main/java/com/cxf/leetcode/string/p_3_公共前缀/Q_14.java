package com.cxf.leetcode.string.p_3_公共前缀;

import java.util.Objects;

public class Q_14 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{""}));
    }

    /**
     * 解法: 暴力法
     * 时间复杂度: T(n) = O(mn) m为strs中长度最小的字符串
     * 空间复杂度: S(n) = O(1)
     */
    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;

        int minLen = strs[0].length();
        for (int i = 1; i < length; i++) {
            int len = strs[i].length();
            if (len < minLen) {
                minLen = len;
            }
        }

        StringBuilder front = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char a = strs[0].charAt(i);
            for (int j = 0; j < length; j++) {
                String str = strs[j];
                if (i >= str.length() || !Objects.equals(str.charAt(i), a)) {
                    return front.toString();
                }
            }
            front.append(a);
        }
        return front.toString();
    }
}
