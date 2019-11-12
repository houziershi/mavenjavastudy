package com.my.reflect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyDemoT {
    public static Pattern pattern = Pattern.compile("[\\t\\n?？]");

    public static void main(String[] args) {
        String str = "15222" +
                "\n" + "\t" + "？来了?" + "垃圾\n"+"" +
                "?中文";
        if (str != null) {
            /*String s1 = str.replace("\t", "");
            String s2 = s1.replace("\n", "");
            String s3 = s2.replace("?", "");
            String s4 = s3.replace("？", "");
            System.out.println(s4);*/
//            String replace = str.replace("[\\t\\n\\?？]", "");

            Matcher m = pattern.matcher(str);

            System.out.println(m.replaceAll(""));
        }
    }


}
