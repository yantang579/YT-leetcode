package com.leetcode.easy;

/**
 * Created by lqy on 2017/11/23.
 *
     In MATLAB, there is a very useful function called 'reshape',
     which can reshape a matrix into a new one with different size but keep its original data.
     You're given a matrix represented by a two-dimensional array,
     and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
     The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
     If the 'reshape' operation with given parameters is possible and legal,
     output the new reshaped matrix; Otherwise, output the original matrix.

    Note:
        The height and width of the given matrix is in range [1, 100].
        The given r and c are all positive.
 *
 */
public class ReshapetheMatrix {
    /*只有原矩阵的row*col==新矩阵的row*col*/
    public int[][] matrixReshape(int[][] nums, int r, int c){
        int old_row=nums.length;
        int old_col=nums[0].length;
        if(old_row*old_col==r*c){
            int[][] res=new int[r][c];
            for(int i=0;i<r*c;i++){
                res[i/c][i%c]=nums[i/old_col][i%old_col];
            }
            return res;
        }
        return nums;
    }
}
