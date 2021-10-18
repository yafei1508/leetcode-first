package com.yafei.p038;

/**
 * @author lyf
 * @date 2021/10/16
 */
public class Solution {
	public static String countAndSay(int n) {
		String str = "1";
		for (int i = 1; i < n; i++) {
			str = generateCountAndSay(str);
		}
		return str;
	}

	/**
	 * 思路：
	 * 1、下一个字符和当前字符不相等，则开始进行拼接
	 * 2、当前字符是最后一个字符，则进行拼接
	 * @param str
	 * @return
	 */
	private static String generateCountAndSay (String str) {
		int ch;
		int count = 0;
		int i = 0;
		StringBuilder stringBuilder = new StringBuilder();
		do {
			ch = str.charAt(i) - '0';
			count = count + 1;
			if (i == str.length() - 1 || ch != (str.charAt(i + 1) - '0')) {
				stringBuilder.append(count);
				stringBuilder.append(ch);
				count = 0;
			}
			i++;
		} while (i < str.length());
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		System.out.println(countAndSay(4));
	}
}
