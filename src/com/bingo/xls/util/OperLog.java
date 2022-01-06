package com.bingo.xls.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OperLog {
    
    private static SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    public static String operLog(String mess) {
        return String.format("%s %s", format.format(new Date()), mess);
    }
   
    public static boolean checkNumber(String str){
        return str.matches("[+-]?[0-9]+(\\.[0-9]+)?");
    }
}
