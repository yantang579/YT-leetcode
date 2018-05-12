package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lqy on 2017/12/31.
 * Lowest Common Ancestor of a Binary Search Tree
 * <p>
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants
 * (where we allow a node to be a descendant of itself).”
 * <p>
 * 注：
 * BST：binary search tree or binary sort tree（二叉排序树，二叉线索树都是一样的定义，就是node的左子树比node值小，node值比右子树的值小）
 */
public class LowestCommonAncestorofaBinarySearchTree {
    /**
     * if(两个节点的值都<当前节点的值) 递归左子树
     * else if(两个节点的值都>当前节点的值) 递归右子树
     * else if(其中一个节点的值等于当前节点的值 || 两个节点一个大于当前节点，一个小于当前节点) 返回当前节点
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        if (p.val == root.val || q.val == root.val || (q.val > root.val && p.val < root.val) || (p.val > root.val && q.val < root.val))
            return root;
        return null;
    }
}
