package com.yafei.p042;

public class Solution {
    /**
     * 解法1 最大值向左和向右遍历找下一个最大值
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxValue) {
                maxIndex = i;
                maxValue = height[i];
            }
        }
        return trap(height, maxIndex, true) + trap(height, maxIndex, false);
    }

    private static int trap(int[] trap, int start, boolean left) {
        if ((start == 0 && left) || (start == trap.length-1 && !left)) {
            return 0;
        }

        int maxIndex;
        int maxValue = 0;
        int res = 0;
        if (left) {
            maxIndex = 0;
            for (int i = start - 1; i >= 0; i--) {
                if (trap[i] > maxValue) {
                    maxIndex = i;
                    maxValue = trap[i];
                }
            }

            res = maxValue * (start - maxIndex);
            for (int i = maxIndex; i < start; i++) {
                res -= trap[i];
            }

        } else {
            maxIndex = trap.length - 1;
            for (int i = start + 1; i < trap.length; i++) {
                if (trap[i] > maxValue) {
                    maxIndex = i;
                    maxValue = trap[i];
                }
            }

            res = maxValue * (maxIndex - start);
            for (int i = start + 1; i <= maxIndex; i++) {
                res -= trap[i];
            }
        }
        return trap(trap, maxIndex, left) + res;
    }


    /**
     * 解法2 双指针
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int leftMax = 0;
        int leftMaxHeight = height[leftMax];
        int rightMax = height.length - 1;
        int rightMaxHeight = height[rightMax];
        int sum = 0;
        while (leftMax <= rightMax) {
            if (leftMaxHeight < rightMaxHeight) {
                sum += leftMaxHeight - height[leftMax++];
                leftMaxHeight = Math.max(leftMaxHeight, leftMax < height.length ? height[leftMax] : 0);
            } else {
                sum += rightMaxHeight - height[rightMax--];
                rightMaxHeight = Math.max(rightMaxHeight, rightMax >= 0 ? height[rightMax] : 0);
            }
        }
        return sum;
    }


        public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[] {4,2,0,3,2,5}));
            System.out.println(new Solution().trap2(new int[] {4,2,3}));
    }
}
