package com.yafei.sort;

import java.util.Arrays;

/**
 * @author lyf
 * @date 2021/10/18
 */
public class QuickSort {
	public static void sort(int[] arr) {
		s(arr, 0, arr.length - 1);
	}

	public static void s(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int l = left;
		int r = right;
		int temp = arr[left];
		while (l < r) {
			while (arr[r] >= temp && l < r) {
				r--;
			}
			while (arr[l] <= temp && l < r) {
				l++;
			}

			if (l < r) {
				int t = arr[r];
				arr[r] = arr[l];
				arr[l] = t;
			}
		}
		arr[left] = arr[l];
		arr[l] = temp;
		s(arr, left, l - 1);
		s(arr, l + 1, right);
	}

	public static void main(String[] args) {
		int[] ints = {1};
		sort(ints);
		System.out.println(Arrays.toString(ints));
	}
}
