package com.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lqy on 2018/5/17.
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 * <p>
 * Example:
 * <p>
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 */
public class N_QueensII {
    int res=0;
    public int totalNQueens(int n) {
        if(n==0) return 0;
        boolean col[]=new boolean[n];
        boolean diagonal1[]=new boolean[2*n-1];
        boolean diagonal2[]=new boolean[2*n-1];
        putQueen(n,0,col,diagonal1,diagonal2);
        return res;
    }

    /**
     *
     * @param n 皇后
     * @param index 当前行
     * @param col 纵向某行是否已被占用
     * @param diagonal1 右上到左下的对角线是否已被占用
     * @param diagonal2 左上到右下的对角线是否已被占用
     */
    private void putQueen(int n,int index,boolean col[], boolean diagonal1[],boolean diagonal2[]){
        if(index==n){
            res++;
            return;
        }
        for(int i=0;i<n;i++){
            if(col[i]==false && diagonal1[index+i]==false && diagonal2[index-i+n-1]==false){
                col[i]=true;
                diagonal1[index+i]=true;
                diagonal2[index-i+n-1]=true;
                putQueen(n,index+1,col,diagonal1,diagonal2);
                col[i]=false;
                diagonal1[index+i]=false;
                diagonal2[index-i+n-1]=false;
            }
        }
    }

}
