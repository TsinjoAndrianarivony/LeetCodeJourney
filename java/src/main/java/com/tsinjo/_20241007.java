package com.tsinjo;

import java.util.Stack;

/**
 * 2696. Minimum String Length After Removing Substrings
 * @author Tsinjo Andrianarivony, 2024-10-07 at 9:54 AM
 */
public class _20241007 {

    public int minLengthStack(String s) {
        // Using a stack to keep track of the valid characters
        Stack<Character> stack = new Stack<>();

        // Iterate through the string
        for (char c : s.toCharArray()) {
            // Check for 'AB' or 'CD' patterns and remove them
            if (!stack.isEmpty() && isValidPair(stack.peek(), c)) {
                stack.pop();  // Remove the valid previous character
            } else {
                stack.push(c);  // Otherwise, push the character to the stack
            }
        }

        // The size of the stack will be the remaining length
        return stack.size();
    }

    private boolean isValidPair(char firstChar, char secondChar) {
        return (firstChar == 'A' && secondChar == 'B') ||
                (firstChar == 'C' && secondChar == 'D');
    }

    public int minLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length() - 1; i++) {
            if (isIndexValid(sb, i)) {
                sb.delete(i, i + 2);
                i = i - (i >= 1 ? 2 : 1);
            }
        }
        return sb.length();
    }

    public boolean isIndexValid(StringBuilder sb, int i) {
        // Store characters in local variables
        char firstChar = sb.charAt(i);
        char secondChar = sb.charAt(i + 1);

        // Return the result using local variables
        return (firstChar == 'A' && secondChar == 'B') ||
                (firstChar == 'C' && secondChar == 'D');
    }


    public int minLengthV1(String s) {
        String previous = s;
        while (true) {
            s = s.replace("AB", "");
            if (s.equals(previous)) {
                s = s.replace("CD", "");
            }
            if (s.equals(previous)) {
                return s.length();
            }
            previous = s;
        }
    }

}
