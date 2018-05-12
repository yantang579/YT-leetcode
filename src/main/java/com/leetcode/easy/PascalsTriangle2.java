package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lqy on 2017/11/21.
 *
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 *
 * Note:
 *      Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangle2 {
    public List<Integer> generate(int rowIndex){
        List<Integer> result=new ArrayList<Integer>();
        for(int k=0,value=1;k<=rowIndex;k++){
            result.add(value);
            value=(int)((long)value*(rowIndex-k)/(k+1));
        }
        return result;
    }
}
