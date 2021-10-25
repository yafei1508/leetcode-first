package com.yafei.p007;

/**
 * @Author lyf
 * @Date 2021/8/21
 */
public class Solution {

	// 12343434
	// res = res * 10 + x % 10;
	// x = res / 10;
	public int reverse(int x) {
		int res = 0;
		while (x != 0) {
			if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
				return 0;
			}
			// 最后一位
			 res = res * 10 + x % 10;
			 x = res / 10;
		}
		return res;
	}
}
