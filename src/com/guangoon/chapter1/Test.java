package com.guangoon.chapter1;

/**
 * Created by guangoon on 10/26/17.
 */
public class Test {
    public static void main(String[] args){
        int i = 4;
        int j = 7;
        i ^= j;
        j ^= i;
        i ^= j;
        System.out.println(i);
        System.out.println(j);
    }
}
