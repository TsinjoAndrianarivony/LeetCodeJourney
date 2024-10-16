package com.tsinjo;

/**
 * @author Tsinjo Andrianarivony, 2024-10-08 at 10:53 AM
 * 1963. Minimum Number of Swaps to Make the String Balanced
 */
public class _20241008 {

    public int minSwaps(String s) {
        int min = 0, add = 0;
        for (int i = 0; i < s.length(); i++) {
            add = (s.charAt(i) - 92) * -1;
            min = min + add;
            if (min < 0) min = 0;
        }
        return (min + 1) / 2;
    }

    public int minSwapsV1(String s) {
        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                min++;
            }
            else {
                if (min > 0) min--;
            }
        }
        return (min + 1) / 2;
    }

}
