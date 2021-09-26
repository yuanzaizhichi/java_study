package com.cxf.leetcode.string.p_2_回文串的定义;

public class Q_125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }

    /**
     * 解法: 双指针
     * 时间复杂度: T(n) = O(n)
     * 空间复杂度: S(n) = O(n)
     */
    public static boolean isPalindrome(String s) {
        int length = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stringBuilder.append(Character.toLowerCase(c));
            }
        }

        int left = 0;
        int right = stringBuilder.length() - 1;

        boolean res = true;
        while (right > left) {
            if (stringBuilder.charAt(right) != stringBuilder.charAt(left)) {
                res = false;
                break;
            }
            right--;
            left++;
        }
        return res;
    }
}
