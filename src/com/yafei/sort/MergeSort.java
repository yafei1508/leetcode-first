package com.yafei.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author lyf
 * @date 2021/10/18
 */
public class MergeSort {
	public static void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}
	public static void sort(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			sort(arr, low, mid);
			sort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int listALow = low;
		int listAHigh = mid;
		int listBLow = mid + 1;
		int listBHigh = high;
		int i = 0;
		while (listALow <= listAHigh && listBLow <= listBHigh) {
			if (arr[listALow] < arr[listBLow]) {
				temp[i] = arr[listALow];
				listALow++;
			} else {
				temp[i] = arr[listBLow];
				listBLow++;
			}
			i++;
		}
		while (listALow <= listAHigh) {
			temp[i++] = arr[listALow++];
		}
		while (listBLow <= listBHigh) {
			temp[i++] = arr[listBLow++];
		}
		for (int x = 0; x < high - low + 1; x++) {
			arr[low + x] = temp[x];
		}
	}

	public static void main(String[] args) {
		int[] ints = {7,3,6,4,8,1,9};
		sort(ints);
		System.out.println(Arrays.toString(ints));
	}
}
