package com.yafei.p006;

import java.util.*;

/**
 * @Author lyf
 * @Date 2021/8/21
 */
public class Solution {
	public static String convert(String s, int numRows) {
		Map<Integer, List<Character>> strMap = new LinkedHashMap<>(numRows);
		for (int i = 0; i < numRows; i++) {
			strMap.put(i, new ArrayList<>());
		}
		int down = numRows;
		int up = numRows - 2;
		boolean directDown = true;
		boolean end;
		for (int i = 0; i < s.length();) {
			if (directDown) {
				end = false;
				for (int x = 0; x < down; x++, i++) {
					if (i >= s.length()) {
						end = true;
						break;
					}
					strMap.get(x).add(s.charAt(i));
				}
				if (end) {
					break;
				}
				directDown = false;
			} else {
				end = false;
				for (int y = 0; y < up; y++, i++) {
					if (i >= s.length()) {
						end =true;
						break;
					}
					strMap.get(numRows - 2 - y).add(s.charAt(i));
				}
				if (end) {
					break;
				}
				directDown = true;
			}

		}
		StringBuilder stringBuilder =new StringBuilder();
		for (Integer i : strMap.keySet()) {
			List<Character> characters = strMap.get(i);
			for (Character c : characters) {
				stringBuilder.append(c);
			}
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
	}
}
