package com.yafei.p070;

public class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        int c = 3;
        if (n == 1) {
            return a;
        }
        if (n == 2) {
            return b;
        }
        int i = 3;
        while (i <= n) {
            c = a + b;
            a = b;
            b = c;
            i++;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(10));
    }
}
