package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.Stack;

/**
 * Created by lqy on 2017/12/31.
 * Given a Binary Search Tree (BST),
 * convert it to a Greater Tree such that
 * every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: The root of a Binary Search Tree like this:
 *    5
 *  /   \
 * 2     13
 * <p>
 * Output: The root of a Greater Tree like this:
 *     18
 *   /   \
 * 20     13
 */
public class ConvertBSTtoGreaterTree {
    /**
     * 思路：
     * BST就是中序遍历一棵树，val值是有序的。
     * 将root中序遍历，每个node再压入栈中，然后出栈，计算该node和之前所有出栈的node的和，然后更改这个node的val
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root;
        Stack<TreeNode> stack= new Stack<TreeNode>();
        Stack<TreeNode> middleOrderStack=new Stack<TreeNode>();
        TreeNode temp=root;
        while(temp!=null || !stack.empty()){
            while(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            if(!stack.empty()){
                temp=stack.pop();
                middleOrderStack.push(temp);
                temp=temp.right;
            }
        }
        int sum=0;
        while(!middleOrderStack.empty()){
            temp=middleOrderStack.pop();
            sum=sum+temp.val;
            temp.val=sum;
        }
        return root;
    }
}
