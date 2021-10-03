package com.yafei.p704;

/**
 * @Author lyf
 * @Date 2021/9/17
 */
public class Solution {
	public static int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		// 最左边下标
		int left = 0;
		// 最右边下标
		int right = nums.length - 1;
		int mid = (left + right) / 2;
		int result = -1;
		while (left <= right) {
			if (nums[mid] == target) {
				result = mid;
				break;
			}
			if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			}
			mid = (left + right) / 2;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] {-1,0,3,5,9,12}, 2));

	}

}
