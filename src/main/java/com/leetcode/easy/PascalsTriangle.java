package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lqy on 2017/11/21.
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * <p>
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int n = 1; n <= numRows; n++) {
            List<Integer> list = new ArrayList<Integer>();
            if (n == 2) {
                list.add(1);
            }
            if (n > 2) {
                list.add(1);
                List<Integer> prelist=new ArrayList<Integer>();
                prelist=result.get(n-2);
                for(int i=1;i<n-1;i++){
                    list.add(prelist.get(i)+prelist.get(i-1));
                }
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }
}
