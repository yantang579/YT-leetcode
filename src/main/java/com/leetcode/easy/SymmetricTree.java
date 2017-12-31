package com.leetcode.easy;
import com.leetcode.classes.TreeNode;
/**
 * Created by yantang on 2017/12/28.
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric
 * But the following [1,2,2,null,3,null,3] is not
 */
public class SymmetricTree {
    /**
     * recurison
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        else if(root.left==null || root.right==null) return false;
        else return isSymmetricTree(root.left,root.right);
    }

    public boolean isSymmetricTree(TreeNode p,TreeNode q){
        if (p == null || q == null) return p == q;
        if (p.val == q.val) return isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
        return false;
    }
}
