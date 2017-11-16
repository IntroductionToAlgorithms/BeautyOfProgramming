package com.guangoon.chapter3;

/**
 * Created by guangoon on 11/16/17.
 */
public class Solution3_3 {
    public static void main(String[] args){
        String A = "Hello12345";
        String B = "sHello12345";
        System.out.println(calculateStringDistance(A.toCharArray(),0,A.length() - 1,
                B.toCharArray(), 0, B.length() - 1));
    }

    public static int calculateStringDistance(char[] A, int aBegin, int aEnd, char[] B, int bBegin, int bEnd){
        if(aBegin > aEnd){
            if(bBegin > bEnd)
                return 0;
            else
                return bEnd - bBegin + 1;
        }

        if(bBegin > bEnd){
            if(aBegin > aEnd)
                return 0;
            else
                return aEnd - aBegin  + 1;
        }

        if(A[aBegin] == B[bBegin])
            return calculateStringDistance(A, aBegin + 1, aEnd, B, bBegin + 1, bEnd);
        else{
            int t1 = calculateStringDistance(A, aBegin, aEnd, B, bBegin + 1, bEnd);
            int t2 = calculateStringDistance(A, aBegin + 1, aEnd, B, bBegin, bEnd);
            int t3 = calculateStringDistance(A, aBegin + 1, aEnd, B, bBegin + 1, bEnd);
            return Math.min(t1, Math.min(t2,t3)) + 1;
        }
    }
}
