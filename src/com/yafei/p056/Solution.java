package com.yafei.p056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author lyf
 * @date 2021/10/19
 */
public class Solution {
	public int[][] merge(int[][] intervals) {
		// 对区间起始位置进行排序
		Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
		int i = 0;
		List<int[]> res = new ArrayList<>();
		while (i < intervals.length) {
			int[] temp = new int[2];
			temp[0] = intervals[i][0];
			temp[1] = intervals[i][1];
			int end = intervals[i][1];
			int j = 1;
			while (i + j < intervals.length && end >= intervals[i + j][0]) {
				temp[1] = Math.max(intervals[i + j][1], end);
				end = temp[1];
				j++;
			}
			i = i + j;
			res.add(temp);
		}
		int[][] re = new int[res.size()][2];
		for (int x = 0; x < res.size(); x++) {
			re[x] = res.get(x);
		}
		return re;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(new Solution().merge(new int[][]{{1, 4}, {0, 2}, {3, 5}})));
	}
}
