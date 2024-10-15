package com.tsinjo;

/**
 * @author Tsinjo Andrianarivony, 2024-10-15 at 9:00 AM
 * 2938. Separate Black and White Balls
 */
public class _20241015 {
    public long minimumSteps(String s) {
        char[] chars = s.toCharArray();
        long swap = 0;
        int currIndex = 0;
        char temp = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                swap += (i - currIndex);
                temp = chars[currIndex];
                chars[currIndex] = chars[i];
                chars[i] = temp;
                currIndex++;
            }
        }
        return swap;
    }

    public static void main(String[] args) {
        new _20241015().minimumSteps("100");
    }
}
