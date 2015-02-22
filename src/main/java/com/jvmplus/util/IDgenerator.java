package com.jvmplus.util;

/**
 * Created by andy on 2/22/15.
 */
public class IDgenerator {
    public static String catalogId(){
        String date = String.valueOf(System.currentTimeMillis());
        return "C" + date.substring(0,9);
    }
    public static String userId(){
        String date = String.valueOf(System.currentTimeMillis());
        return "U" + date.substring(0,9);
    }
    public static String blogId(){
        String date = String.valueOf(System.currentTimeMillis());
        return "B" + date.substring(0,9);
    }
}
