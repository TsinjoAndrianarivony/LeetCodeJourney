package com.tsinjo;

import java.util.*;

/**
 * @author Tsinjo Andrianarivony, 2024-10-12 at 7:59 AM
 * Divide Intervals Into Minimum Number of Groups
 */
public class _20241012 {

    public int minGroups(int[][] arrayIntervals) {
        int[] starts = new int[arrayIntervals.length];
        int[] ends = new int[arrayIntervals.length];

        for (int i = 0; i < ends.length; i++) {
            starts[i] = arrayIntervals[i][0];
            ends[i] = arrayIntervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int i = 0, j = 0, r = 0;
        while (i < starts.length) {
            if (starts[i] <= ends[j]) {
                i++;
            }
            else {
                j++;
            }
            r = Math.max(r, i - j);
        }
        return r;
    }

}
