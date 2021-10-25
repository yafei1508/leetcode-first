package com.yafei.p009;

/**
 * @Author lyf
 * @Date 2021/8/22
 */
public class Solution {
	public static boolean isPalindrome(int x) {
		String s = String.valueOf(x);
		if (s.length() < 2) {
			return true;
		}
		for (int i =0; i<= s.length()/2;i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(1223221));
	}
}
