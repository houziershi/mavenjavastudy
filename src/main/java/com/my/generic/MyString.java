package com.my.generic;

public class MyString {

    public static String normalize(String pathname) {
        int n = pathname.length();
        char[] normalized = pathname.toCharArray();
        int index = 0;
        char prevChar = 0;
        for (int i = 0; i < n; i++) {
            char current = normalized[i];
            // Remove duplicate slashes.
            if (!(current == '/' && prevChar == '/')) {
                normalized[index++] = current;
            }

            prevChar = current;
        }

        // Omit the trailing slash, except when pathname == "/".
        if (prevChar == '/' && n > 1) {
            index--;
        }

        return (index != n) ? new String(normalized, 0, index) : pathname;
    }

    public static void main(String[] args) {
        System.out.println(normalize("//hgk/ou/print//in/"));
    }
}
