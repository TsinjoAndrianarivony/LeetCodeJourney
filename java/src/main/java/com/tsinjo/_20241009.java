package com.tsinjo;

/**
 * @author Tsinjo Andrianarivony, 2024-10-09 at 5:50 PM
 */
public class _20241009 {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }
        return open + close;
    }

}
