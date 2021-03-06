package com.leetcode.easy;
import com.leetcode.classes.TreeNode;

import java.util.Stack;

/**
 * Created by yantang on 2017/12/23.
 * <p>
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 * <p>
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
 * <p>
 * Example 1:
 * Input: Binary tree: [1,2,3,4]
 *      1
 *    /   \
 *   2     3
 *  /
 * 4
 * <p>
 * Output: "1(2(4))(3)"
 * <p>
 * Explanation: Originallay it needs to be "1(2(4)())(3()())",
 * but you need to omit all the unnecessary empty parenthesis pairs.
 * And it will be "1(2(4))(3)".
 * Example 2:
 * Input: Binary tree: [1,2,3,null,4]
 *    1
 *  /   \
 * 2     3
 *  \
 *   4
 * <p>
 * Output: "1(2()(4))(3)"
 * <p>
 * Explanation: Almost the same as the first example,
 * except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output
 *
 * 解析：前序遍历一个二叉树，并且将所有*可以省略*的括号省略。
 */
public class ConstructStringfromBinaryTree {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    /**
     * 方法一：
     * 比较快，因为用了StringBuilder
     * 递归
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {
        StringBuilder str=new StringBuilder();
        helper(str,t);
        return str.toString();

    }
    public void helper(StringBuilder str,TreeNode t){
        if(t!=null){
            str.append(t.val);
            if(t.left!=null || t.right!=null){
                str.append('(');
                helper(str,t.left);
                str.append(')');
                if(t.right!=null){
                    str.append('(');
                    helper(str,t.right);
                    str.append(')');
                }
            }
        }
    }

    public String tree2str2(TreeNode t){
        if(t==null) return "";
        if(t.left==null && t.right==null) return t.val+"";
        if(t.right==null) return t.val+"("+tree2str2(t.left)+")";
        return t.val+"("+tree2str2(t.left)+")"+"("+tree2str2(t.right) +")";
    }
}
