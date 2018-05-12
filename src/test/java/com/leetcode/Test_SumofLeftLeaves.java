package com.leetcode;

import com.leetcode.classes.TreeNode;
import com.leetcode.easy.SumofLeftLeaves;
/**
 * Created by lqy on 2017/12/31.
 */
public class Test_SumofLeftLeaves {
    public static void main(String[] args){
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        TreeNode cur=root.right;
        cur.left= new TreeNode(15);
        cur.right= new TreeNode(7);
        SumofLeftLeaves test= new SumofLeftLeaves();

        System.out.println(test.sumOfLeftLeaves(root));
    }
}
