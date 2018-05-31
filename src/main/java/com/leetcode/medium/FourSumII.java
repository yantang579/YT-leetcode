package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lqy on 2018/5/31.
 * <p>
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * <p>
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 * <p>
 * Example:
 * <p>
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A.length==0) return 0;
        int length=A.length;
        int res=0;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                if(map.containsKey(A[i]+B[j]))
                    map.put(A[i]+B[j],map.get(A[i]+B[j])+1);
                else
                    map.put(A[i]+B[j],1);
            }
        }
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                if(map.containsKey(0-C[i]-D[j]))
                    res+=map.get(0-C[i]-D[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A=new int[]{1,2};
        int[] B=new int[]{-2,-1};
        int[] C=new int[]{-1,2};
        int[] D=new int[]{0,2};
        FourSumII fourSumII=new FourSumII();
        fourSumII.fourSumCount(A,B,C,D);

    }
}
