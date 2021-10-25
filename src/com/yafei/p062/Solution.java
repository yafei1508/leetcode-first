package com.yafei.p062;

import java.math.BigInteger;

public class Solution {
    public int uniquePaths(int m, int n) {
        BigInteger res = new BigInteger("1");
        for (int i = n; i <= m + n - 2; i++) {
            res = res.multiply(new BigInteger(String.valueOf(i)));
        }
        for (int i = m-1; i >= 1; i--) {
            res = res.divide(new BigInteger(String.valueOf(i)));
        }
        return res.intValue();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(23, 12));
    }
}
