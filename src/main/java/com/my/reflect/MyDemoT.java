package com.my.reflect;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyDemoT {
    public static Pattern pattern = Pattern.compile("[\\t\\n?？]");

    public static void main(String[] args) {
        String str = "15222" +
                "\n" + "\t" + "？来了?" + "垃圾\n" + "" +
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

        int[] test = new int[0];
        System.out.println("........................");

        /*List<String> list = new ArrayList<String>();
        list.add("");
        for (int i = 0; i < 10000; i++) {
            list = list.subList(0, 1);
        }
        list.clear();*/

        BigDecimal a = new BigDecimal("5");
        BigDecimal b = new BigDecimal("2.5");

        System.out.println(a.divide(b, 1, BigDecimal.ROUND_FLOOR));

        MyReflect myReflect = new MyReflect(1);
        MyReflect myReflect1 = new MyReflect(1);
        if (myReflect.equals(myReflect1)) {
            System.out.println("...... equal");
        }
        if (myReflect != myReflect1) {
            System.out.println("......no equal");
        }

    }


}
