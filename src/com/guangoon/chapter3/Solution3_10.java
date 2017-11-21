package com.guangoon.chapter3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by guangoon on 11/21/17.
 */
public class Solution3_10 {
    private static class Tree{
        int value;
        Tree left;
        Tree right;
    }

    public void printNodeByLevel(Tree root){
        Queue<Tree> q = new LinkedList<>();
        q.offer(root);
        int size = 1;
        while(size > 0){
            int count = size;
            while(!q.isEmpty() && count > 0){
                Tree t = q.poll();
                count--;
                System.out.print(t.value + " ");
                if(t.left != null)
                    q.offer(t.left);
                if(t.right != null)
                    q.offer(t.right);
            }
            size = q.size();
            System.out.println();
        }
    }
}
