package com.stylefeng.guns.rest.persistence.utils;

/**
 * Created by ZhangYao
 * Date 2019/4/24 Time 9:59
 */
public class StringArrayConcatUtil {
    private StringArrayConcatUtil(){}
    public static String concatWithSperator (String [] origin, String seperator) throws Exception {
        if (origin == null){
            throw new Exception("origin cannot be null");
        }
        StringBuilder sb = new StringBuilder();
        int length = origin.length;
        int count = 0;
        for (String slice : origin) {
            sb.append(slice);
            count++;
            if (count<length){
                sb.append(seperator);
            }
        }
        return sb.toString();
    }
}
