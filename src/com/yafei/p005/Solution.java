package com.yafei.p005;

/**
 * @Author lyf
 * @Date 2021/8/18
 */

public class Solution {
	public static String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		int left = 0;
		int right = 0;
		char[] charArr = s.toCharArray();
		int x;
		int max = 1;
		int len;
		for (int i =0; i < s.length(); i++) {
			x = 1;
			len = 1;
			while (i - x >= 0 && i + x < s.length()) {
				if (charArr[i-x] != charArr[i + x]) {
					break;
				}
				x++;
				len = len + 2;
			}
			if (len > max) {
				left = i - (x - 1);
				right = i + (x - 1);
				max = len;
			}


			if (i != s.length() - 1 && charArr[i] == charArr[i + 1]) {
				int j = i + 1;
				x = 1;
				len = 2;
				while (i - x >= 0 && j + x < s.length()) {
					if (charArr[i - x] != charArr[j + x]) {
						break;
					}
					x++;
					len = len + 2;
				}
			}
			if (len > max) {
				left = i - (x - 1);
				right = i + 1 + (x - 1);
				max = len;
			}
		}
		return s.substring(left, right + 1);
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("aba"));
	}
}
