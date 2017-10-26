package com.guangoon.chapter1;

/**
 * Created by guangoon on 10/25/17.
 */
public class Solution1_2 {
    static final int HALF_BIT_LENGTH = 4;
    static final int FULLMASK = 255;
    static final int LMASK = (FULLMASK << HALF_BIT_LENGTH);
    static final int RMASK = (FULLMASK >> HALF_BIT_LENGTH);

    static char rGet(char b){
        return (char)(b&RMASK);
    }

    static char lGet(char b){
        return (char)(b&LMASK);
    }
    static char rSet(char b, int n){
        return (char)((b&LMASK)|n);
    }

    static char lSet(char b, int n){
        return (char)((b&RMASK)|(n << HALF_BIT_LENGTH));
    }

    public static void displaySolution2(){
        char b = 0;
        for(b = lSet(b,1); lGet(b) <= 9; lSet(b, lGet(b) + 1)){
            for(b = rSet(b, 1); rGet(b) <= 9; rSet(b, rGet(b) + 1)){
                if(lGet(b) % 3 != rGet(b) % 3){
                    System.out.println("A = " + lGet(b) + ",B = " + rGet(b));
                }
            }
        }
    }

    public static void displaySolution1(){
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= 9; j++){
               if(i % 3 != j % 3){
                System.out.println("A = " + i + ",B = " + j);
               }
            }
        }
    }

    public static void displaySolution3(){
        int i = 81;
        while(i-- > 0){
            if(i / 9 % 3 != i % 9 % 3){
                System.out.println("A = " + (i / 9  + 1) + ",B = " + (i % 9  + 1));
            }
        }
    }


    public static void main(String[] args){
        displaySolution3();
    }
}
