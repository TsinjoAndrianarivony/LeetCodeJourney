package com.tsinjo;

import java.util.Stack;

/**
 * @author Tsinjo Andrianarivony, 2024-10-10 at 10:56 AM
 * 962. Maximum Width Ramp
 */
public class _20241010 {
    public int maxWidthRamp(int[] nums) {
        int[] maxArray = new int[nums.length];
        maxArray[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            maxArray[i] = Math.max(nums[i], maxArray[i + 1]);
        }

        int max = 0, i = 0, j = 0;
        while (j < nums.length) {
            if (i == j) {
                j++;
            }
            else if (nums[i] <= maxArray[j]) {
                if (nums[j] >= nums[i]) max = Math.max(max, j - i);
                j++;
            }
            else {
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {
            9,
            8,
            1,
            0,
            1,
            9,
            4,
            0,
            4,
            1
        };
        _20241010 obj = new _20241010();
        System.out.println(obj.maxWidthRamp(nums));
    }
}
