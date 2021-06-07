package com.cxf.leetcode;

public class Q_5 {
    public static void main(String[] args) throws Exception {
        //回文子串：中心对称，依次从左从右返回的字符串都相等
        //如"bab","baab"

        String str = "aacabdkacaa";
        System.out.println(Q5Solution2.longestPalindrome(str));
    }
}

//暴力循环，O(n三次方)，无法通过leetcode...
class Q5Solution {
    public static String longestPalindrome(String s) {
        int startIndex = 0, endInedx = 0, maxLen = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String subStr = s.substring(i, j);
                if (isPalindromic(subStr)) {
                    if (subStr.length() > maxLen) {
                        maxLen = subStr.length();
                        startIndex = i;
                        endInedx = j;
                    }
                }
            }
        }
        return s.substring(startIndex, endInedx);
    }

    public static boolean isPalindromic(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) return false;
        }
        return true;
    }
}

//中心扩展
class Q5Solution2 {
    public static String longestPalindrome(String s) {
        int startIndex = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > maxLen) {
                maxLen = len;
                startIndex = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(startIndex, startIndex + maxLen);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}