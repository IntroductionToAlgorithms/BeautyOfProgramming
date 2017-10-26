package com.guangoon.chapter1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by guangoon on 10/26/17.
 */
public class Solution1_3 {
    static int N;
    static int[] arr;
    static int maxSwap;
    static int[] swapArray;

    static int upperBound(){
        return 2 * N - 3;
    }

    static int lowerBound(){
        int ret = 0;
        for(int i = 1; i < N; i++){
            int t = arr[i] - arr[i - 1];
            if(t == 1 || t == -1){

            }else{
                ret++;
            }
        }
        return ret;
    }

    static boolean isSorted(){
        for(int i = 1; i < N; i++){
            if(arr[i - 1] > arr[i])
                return false;
        }
        return true;
    }

    static void reverse(int i, int j){
        while(i < j){
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
            i++;
            j--;
        }
    }

    public static void search(int step){
        int estimate = lowerBound();
        if(estimate + step > maxSwap){
            return;
        }

        if(isSorted() && step < maxSwap){
            maxSwap = step;
            return;
        }

        for(int i = 1; i < N; i++){
            reverse(0, i);
            swapArray[step] = i;
            search(step + 1);
            reverse(0, i);
        }
    }
    public static void main(String[] args){
        try {
            System.setIn(new FileInputStream("input/input1_3.txt"));
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            for(int testcase = 1; testcase <= T; testcase++){
                N = sc.nextInt();
                arr = new int[N];
                for(int i = 0; i < N; i++){
                    arr[i] = sc.nextInt();
                }
            }
            maxSwap = upperBound();
            swapArray = new int[maxSwap + 1];
            search(0);
            System.out.println(maxSwap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
