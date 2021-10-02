package com.yafei.p400;

import java.util.Arrays;

/**
 * @Author lyf
 * @Date 2021/8/22
 */
public class Solution {
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(nums, 1);
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i;j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(dp[i], res);
		}
		return res;
	}
}

class cc {

}
