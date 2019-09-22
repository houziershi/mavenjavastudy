package com.leetcode;

import java.util.Stack;

public class ValidParentheses {

    /*public static boolean validParenthess(String str) {


    }*/

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("(");
        stack.push(")");
        stack.push("[");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
