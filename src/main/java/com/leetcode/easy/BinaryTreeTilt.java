package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

/**
 * Created by lqy on 2017/12/31.
 * <p>
 * Given a binary tree, return the tilt of the whole tree.
 * The tilt of a tree node is defined as
 * the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values.
 * Null node has tilt 0.
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 * <p>
 * 思路：
 * 求出各个节点左右子树的差的绝对值，将这些绝对值求和并返回。
 * 左右子树的差 = | 左子树所有节点的值的和 - 右子树所有节点的值的和 |
 * (并不是只算各个节点左右孩子的差)
 */
public class BinaryTreeTilt {
    public int sum=0;
    public int findTilt(TreeNode root) {
        postOrder(root);
        return sum;
    }
    public int postOrder(TreeNode root){
        if(root==null) return 0;
        int left=postOrder(root.left);
        int right=postOrder(root.right);
        sum+=Math.abs(left-right);
        return left+right+root.val;
    }
}
