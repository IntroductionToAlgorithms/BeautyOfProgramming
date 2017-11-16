package com.guangoon.chapter3;

/**
 * Created by guangoon on 11/13/17.
 */
public class Solution3_1 {
    static char[] src = {'A','A','B','B','C','D'};
    static char[] des = {'C','D','A','A'};
    public static boolean fun1(char[] src, char[] des){
        int len = src.length;
        for(int i = 0; i < len; i++) {
            char tempchar = src[0];
            for (int j = 0; j < len - 1; j++) {
                src[j] = src[j + 1];
            }
            src[len - 1] = tempchar;
            if(strstr(src,des))
                return true;
        }
        return false;
    }

    public static boolean fun2(char[] src, char[] des){
        char[] doubleSrc = new char[src.length * 2];
        for(int i = 0; i < src.length; i++){
            doubleSrc[i] = src[i];
            doubleSrc[i + src.length] = src[i];
        }

        for(int i = 0; i < doubleSrc.length - des.length; i++){
            if(strstr(doubleSrc,i,des))
                return true;
        }
        return false;
    }

    public static boolean strstr(char[] src, char[] des){
        if(des.length > src.length)
            return false;
        for(int i = 0; i < des.length; i++){
            if(src[i] != des[i])
                return false;
        }
        return true;
    }

    public static boolean strstr(char[] src,int start, char[] des){
        if(des.length > src.length)
            return false;
        for(int i = 0; i < des.length && (i + start) < src.length; i++){
            if(src[i + start] != des[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(fun1(src,des));
        System.out.println(fun2(src,des));
    }
}
