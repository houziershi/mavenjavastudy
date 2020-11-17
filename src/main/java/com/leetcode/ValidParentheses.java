package com.leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class ValidParentheses {

    /*public static boolean validParenthess(String str) {


    }*/

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static boolean isValid(String s) {
        // write code here
        String lefty = "({[";
        String righty = ")}]";
        LinkedList<String> statck = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (lefty.contains(c)) {
                statck.push(c);
            } else if (righty.contains(c)) {
                if (statck.size() == 0) {
                    return false;
                }
                if (righty.indexOf(c) != lefty.indexOf(statck.pop())) {
                    return false;
                }
            }
        }

        return statck.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println("ValidParentheses........." + ValidParentheses.isValid2("["));
    }
}
