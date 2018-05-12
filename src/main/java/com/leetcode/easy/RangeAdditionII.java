package com.leetcode.easy;

import java.util.Arrays;

/**
 * Created by lqy on 2017/12/7.
 * <p>
 * Given an m * n matrix M initialized with all 0's and several update operations.
 * <p>
 * Operations are represented by a 2D array, and each operation is represented by an array with two positive integers a and b, which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.
 * <p>
 * You need to count and return the number of maximum integers in the matrix after performing all the operations.
 * <p>
 * Example 1:
 * Input:
 * m = 3, n = 3
 * operations = [[2,2],[3,3]]
 * Output: 4
 * Explanation:
 * Initially, M =
 * [[0, 0, 0],
 * [0, 0, 0],
 * [0, 0, 0]]
 * <p>
 * After performing [2,2], M =
 * [[1, 1, 0],
 * [1, 1, 0],
 * [0, 0, 0]]
 * <p>
 * After performing [3,3], M =
 * [[2, 2, 1],
 * [2, 2, 1],
 * [1, 1, 1]]
 * <p>
 * So the maximum integer in M is 2, and there are four of it in M. So return 4.
 * Note:
 * The range of m and n is [1,40000].
 * The range of a is [1,m], and the range of b is [1,n].
 * The range of operations size won't exceed 10,000.
 */
public class RangeAdditionII {
    /**
     *  Memory Limit Exceeded
     * @param m
     * @param n
     * @param ops
     * @return
     */
    public int maxCount(int m, int n, int[][] ops) {
        int k=0;
        int res[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[i][j]=0;
            }
        }
        while(k<ops.length){
            int a=ops[k][0];
            int b=ops[k][1];
            for(int i=0;i<a;i++){
                for(int j=0;j<b;j++){
                    res[i][j]+=1;
                }
            }
        }
        int maxNum=res[0][0];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(res[i][j]==maxNum)
                    count++;
                else
                    break;
            }
        }
        return count;
    }

    public int maxCoutn(int m,int n,int[][] ops){
        int k=0;
        if(ops.length==0)
            return m*n;
        int aMin=Integer.MAX_VALUE,bMin=Integer.MAX_VALUE;
        for(k=0;k<ops.length;k++){
            aMin=aMin<ops[k][0]?aMin:ops[k][0];
            bMin=bMin<ops[k][1]?bMin:ops[k][1];
        }
        return aMin*bMin;
    }
}
