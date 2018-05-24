package com.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lqy on 2018/5/17.
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class N_Queens {
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    public List<List<String>> solveNQueens(int n) {
        if(n==0) return new ArrayList<List<String>>();
        boolean col[]=new boolean[n];
        boolean diagonal1[]=new boolean[2*n-1];
        boolean diagonal2[]=new boolean[2*n-1];
        putQueen(n,0,new ArrayList<Integer>(),col,diagonal1,diagonal2);
        List<List<String>> result=new ArrayList<List<String>>();
        for(int i=0;i<res.size();i++){//遍历解决方案
            List<String> temp=new ArrayList<String>();
            for(int j=0;j<n;j++){//遍历行
                int index=res.get(i).get(j);
                StringBuilder sb=new StringBuilder();
                for(int k=0;k<n;k++) {//遍历该行的元素
                    if(k!=index) sb.append(".");
                    else sb.append("Q");
                }
                temp.add(sb.toString());
            }
            result.add(temp);
        }
        return result;

    }

    /**
     * 尝试在一个n皇后问题中，解决第index行的皇后的摆放问题
     * @param n 皇后
     * @param index 当前行
     * @param row 当前解决方案中，每行存放皇后的位置
     * @param col 纵向某行是否已被占用
     * @param diagonal1 右上到左下的对角线是否已被占用
     * @param diagonal2 左上到右下的对角线是否已被占用
     */
    private void putQueen(int n,int index,List<Integer> row,boolean col[],boolean diagonal1[],boolean diagonal2[]){
        if(index==n){
            res.add(new ArrayList<Integer>(row));
        }
        for(int i=0;i<n;i++){
            if(col[i]==false && diagonal1[index+i]==false && diagonal2[index-i+n-1]==false){
                row.add(i);
                col[i]=true;
                diagonal1[index+i]=true;
                diagonal2[index-i+n-1]=true;
                putQueen(n,index+1,row,col,diagonal1,diagonal2);
                row.remove(row.size()-1);
                col[i]=false;
                diagonal1[index+i]=false;
                diagonal2[index-i+n-1]=false;
            }
        }
    }
}
