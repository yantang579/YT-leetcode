package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

/**
 * Created by lqy on 2018/1/2.
 * <p>
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
public class PathSumIII {
    /**
     * 以每一个节点作为路径根节点进行前序遍历，查找每一条路径的权值和与sum是否相等。
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        int res=findPath(root,0,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
        return res;
    }
    public int findPath(TreeNode root,int total,int sum){
        if(root==null) return 0;
        total+=root.val;
        if(total==sum) return findPath(root.left,total,sum)+findPath(root.right,total,sum)+1;
        return findPath(root.left,total,sum)+findPath(root.right,total,sum);
    }
}

