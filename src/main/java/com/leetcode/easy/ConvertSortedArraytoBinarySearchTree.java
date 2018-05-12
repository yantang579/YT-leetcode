package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

/**
 * Created by lqy on 2017/12/31.
 * <p>
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem,
 * a height-balanced binary tree is defined as
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        int mid=(0+nums.length-1)/2;
        TreeNode root=helper(nums,0, nums.length-1);
        return root;
    }
    public TreeNode helper(int[] nums,int left,int right){
        if(left<=right){
            int mid=(right-left)/2+left;
            TreeNode root= new TreeNode(nums[mid]);
            root.left=helper(nums,left,mid-1);
            root.right=helper(nums,mid+1,right);
            return root;
        }
        return null;
    }
}
