package com.ccc.util;

public class PrintUtil {

    public PrintUtil() {}

    public static void printf(String format, String str) {
        System.out.printf(format, str);
    }
    public static void printf(String format, String strOne, String strTwo) {
        System.out.printf(format, strOne, strTwo);
    }
    public static void printf(String format, String strOne, double cost) {
        System.out.printf(format, strOne, cost);
    }
    public static void printf(String str) {
        System.out.printf(str);
    }
}
