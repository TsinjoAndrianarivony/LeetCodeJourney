package com.tsinjo;

import java.util.PriorityQueue;

/**
 * @author Tsinjo Andrianarivony, 2024-10-14 at 9:24 AM
 * 2530. Maximal Score After Applying K Operations
 */
public class _20241014 {
}

class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num: nums) {
            queue.offer(num);
        }

        long score = 0;
        while (k > 0) {
            int value = queue.poll();
            if (value == 1) break;
            score += value;
            queue.offer((int)Math.ceil((double)value / 3));
            k--;
        }

        return score + k;
    }

}
