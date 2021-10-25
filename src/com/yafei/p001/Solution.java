package com.yafei.p001;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * @Author lyf
 * @Date 2021/7/5
 */
public class Solution {
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		Arrays.sort(nums);
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				res[0] = map.get(nums[i]);
				res[1] = map.get(target - nums[i]);
				return res;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
	}
}
