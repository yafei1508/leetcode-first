package com.yafei.p004;

/**
 * @Author lyf
 * @Date 2021/8/16
 */
public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] less;
		int[] more;
		if (nums1.length < nums2.length) {
			less = nums1;
			more = nums2;
		} else {
			less = nums2;
			more = nums1;
		}
		// 少中
		int lessMid = less.length / 2;
		int lessLeft = 0;
		int lessRight = less.length - 1;
		int moreMid = more.length / 2;
		int moreLeft = 0;
		int moreRight = more.length - 1;
		int move = 0;
		while (lessRight - lessLeft > 0 && moreRight - moreLeft > 0) {
			if (less[lessMid] < more[moreMid]) {
				move = lessMid - lessLeft;
				lessLeft = lessLeft + move;
				moreRight = moreRight - move;
			} else if (less[lessMid] > more[moreMid]){
				move = lessRight - lessMid;
				lessRight = lessRight - move;
				moreLeft = moreLeft + move;
			} else {
				if (less.length % 2 == more.length % 2) {

				}
			}

		}
		return 1.2;
	}

}
