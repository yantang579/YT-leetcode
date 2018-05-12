package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lqy on 2018/1/2.
 *
 * Given a Binary Search Tree and a target number,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 */
public class TwoSumIVInputisaBST {
    /**
     * set
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set= new HashSet<Integer>();
        return dfs(root,set,k);
    }
    public boolean dfs(TreeNode root,Set<Integer> set,int k){
        if(root!=null){
            if(set.contains(k-root.val)) return true;
            set.add(root.val);
            return dfs(root.left,set,k) || dfs(root.right,set,k);
        }
        return false;
    }

    /**
     * ArrayList
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget2(TreeNode root,int k){
        List<Integer> list = new ArrayList<Integer>();
        inOrder(root,list);
        for(int i=0,j=list.size()-1;i<j;){
            if(list.get(i)+list.get(j)==k) return true;
            else if(list.get(i)+list.get(j)<k) i++;
            else j--;
        }
        return false;
    }
    public void inOrder(TreeNode root,List<Integer> list){
        if(root==null) return ;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);

    }
}
