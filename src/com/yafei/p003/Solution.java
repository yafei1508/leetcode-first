package com.yafei.p003;

import java.lang.management.ManagementFactory;
import java.util.*;
import java.util.stream.Stream;

/**
 * @Author lyf
 * @Date 2021/8/16
 */
class Solution {
	public static int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int len = 0;
		int left =  0;

		for (int i = 0; i < s.length(); i++ ) {
			if (map.containsKey(s.charAt(i))) {
				left = Math.max(left, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			len = Math.max(len, i - left + 1);
		}
		return len;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
}
