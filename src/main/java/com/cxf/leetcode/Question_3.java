package com.cxf.leetcode;

import java.util.HashMap;

public class Question_3 {
    public static void main(String[] args) throws Exception {
        System.out.println(Q3Solution.lengthOfLongestSubstring("abcabcbb"));
    }
}

class Q3Solution {
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (hashMap.containsKey(c)) {
                //增加一个指针i，当出现重复的元素时，锁住左边，计算当前子串长度
                i = Math.max(i, hashMap.get(c) + 1);
            }
            hashMap.put(c, j);
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

}
