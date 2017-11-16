package com.guangoon.chapter3;

/**
 * Created by guangoon on 11/13/17.
 */
public class Solution3_2 {
    static char[][] c = {{}, {}, {'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}, {'J', 'K', 'L'},
            {'M', 'N', 'O'}, {'P', 'Q', 'R', 'S'}, {'T', 'U', 'V'}, {'W', 'X', 'Y', 'Z'}};
    static int[] total = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};


    public static void recursiveSearch(int[] number, int[] answer, int index, int n) {
        if (index == n) {
            for (int i = 0; i < number.length; i++) {
                if(total[number[i]] > 0)
                    System.out.print(c[number[i]][answer[i]]);
            }
            System.out.println();
            return;
        }

        while ( index < n && total[number[index]] == 0 ) {
            index++;
        }
        for (answer[index] = 0; answer[index] < total[number[index]]; answer[index]++) {
            recursiveSearch(number, answer, index + 1, n);
        }
    }

    public static void main(String[] args) {
        int[] number = {0,1,2, 2};
        int[] answer = new int[number.length];
        recursiveSearch(number, answer, 0, number.length);
    }
}
