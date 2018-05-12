package com.leetcode;

import com.leetcode.classes.TreeNode;
import com.leetcode.easy.ConvertBSTtoGreaterTree;

/**
 * Created by lqy on 2017/12/31.
 */
public class Test_ConvertBSTtoGreaterTree {
    public static void main(String[] args){
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(2);
        root.right=new TreeNode(13);
        ConvertBSTtoGreaterTree test= new ConvertBSTtoGreaterTree();
        test.convertBST(root);
    }
}
