package com.cxf.leetcode.other;

import java.util.Stack;

public class Q_7 {
    public static void main(String[] args) throws Exception {
        System.out.println(Q7Solution2.reverse(-134));
    }
}

/**
 * 使用栈
 */
class Q7Solution {
    public static int reverse(int x) {
        String frontStr = "";
        String s = String.valueOf(x);
        if (x < 0) {
            frontStr = s.substring(0, 1);
            s = s.substring(1);
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) stack.push(c);

        String resStr = "";
        while (!stack.empty()) {
            resStr += stack.pop();
        }

        long res = Long.parseLong(frontStr + resStr);
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) return 0;
        return (int) res;
    }
}

class Q7Solution2 {
    public static int reverse(int x) {
        long res = 0;
        // 考虑负数情况，所以这里条件为: x != 0
        while (x != 0) {
            //构建上一级并加上下一级的数
            res = res * 10 + (x % 10);
            //削级
            x /= 10;
        }
        return res < Integer.MIN_VALUE || res > Integer.MAX_VALUE ? 0 : (int) res;
    }
}