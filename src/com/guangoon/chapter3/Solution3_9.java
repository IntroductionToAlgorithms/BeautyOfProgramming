package com.guangoon.chapter3;

/**
 * Created by guangoon on 11/21/17.
 */

   class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Solution3_9 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode  buildTree(int[] preorder, int pStart, int pEnd,
                               int[] inorder, int iStart, int iEnd){
        if(pStart > pEnd || iStart > iEnd)
            return null;
        int pos = -1;
        for(int i = iStart; i <= iEnd; i++){
            if(preorder[pStart] == inorder[i]){
                pos = i;
                break;
            }
        }

        TreeNode root = new TreeNode(inorder[pos]);
        root.left = buildTree(preorder, pStart + 1, pStart + pos - iStart, inorder, iStart, pos -1);
        root.right = buildTree(preorder, pEnd - iEnd + pos + 1, pEnd, inorder, pos + 1, iEnd);
        return root;
    }

}
