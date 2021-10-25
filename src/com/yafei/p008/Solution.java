package com.yafei.p008;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lyf
 * @Date 2021/8/21
 */
public class Solution {
	public static int myAtoi(String s) {
		Automation automation = new Automation();
		for (int i = 0; i < s.length();i++) {
			automation.getChar(s.charAt(i));
		}
		return automation.getAns();
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("42"));
	}
}

class Automation {
	private int sign = 1;
	private long ans = 0;
	private String state = "start";



	public int getAns() {
			return (int) (sign * ans);
	}

	private static final Map<String, String[]> TABLE = new HashMap<>();
	static {
		TABLE.put("start", new String[]{"start", "signed", "in_number", "end"});
		TABLE.put("end", new String[]{"end", "end", "end", "end"});
		TABLE.put("in_number", new String[]{"end", "end", "in_number", "end"});
		TABLE.put("signed", new String[]{"end", "end", "in_number", "end"});
	}

	public void getChar(char c) {
			int type = getType(c);
			state = TABLE.get(state)[type];
			if ("signed".equals(state)) {
				sign = '+' == c ? 1 : -1;
			}else if ("in_number".equals(state)) {
				ans = ans * 10 +  (c - '0');
				ans = sign == 1 ? Math.min(Integer.MAX_VALUE, ans) : Math.min(-1L * Integer.MIN_VALUE, ans);
			}
	}

	public int getType (char c) {
		// 空格
		if (c == ' ') {
			return 0;
		}
		// 符号
		if (c == '+' || c == '-') {
			return 1;
		}
		// 数字
		if (c >= '0' && c <= '9') {
			return 2;
		}

		return 3;
	}
}
