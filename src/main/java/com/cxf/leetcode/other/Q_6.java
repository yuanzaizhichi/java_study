package com.cxf.leetcode.other;

import java.util.ArrayList;
import java.util.List;

public class Q_6 {
    public static void main(String[] args) throws Exception {
        String str = "PAYPALISHIRING";
        System.out.println(Q6Solution.convert(str, 3));
    }
}

class Q6Solution {
    public static String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> lst = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            lst.add(new StringBuilder());
        }

        int sbIndex = 0;
        boolean flag = false;
        for (char c : s.toCharArray()) {
            lst.get(sbIndex).append(c);
            if (sbIndex == 0 || sbIndex == numRows - 1) flag = !flag;
            sbIndex += flag ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder : lst) res.append(stringBuilder);
        return res.toString();
    }
}
