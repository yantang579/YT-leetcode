package com.leetcode.medium;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lqy on 2018/5/2.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int result = 0;
        int length = triangle.size();
        int[][] dp = new int[length][length];
        for(int i=0;i<length;i++)
        for (int j = 0; j <=i; j++) {
            dp[i][j] = triangle.get(i).get(j);
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                dp[i][j] += Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Triangle triangle=new Triangle();
        //[[2],[3,4],[6,5,7],[4,1,8,3]]
        List<List<Integer>> tri=new ArrayList<List<Integer>>();
        List<Integer> temp=new ArrayList<Integer>();
        temp.add(2);
        tri.add(temp);
        List<Integer> temp2=new ArrayList<Integer>();
        temp2.add(3);
        temp2.add(4);
        tri.add(temp2);
        List<Integer> temp3=new ArrayList<Integer>();
        temp3.add(6);
        temp3.add(5);
        temp3.add(7);
        tri.add(temp3);
        List<Integer> temp4=new ArrayList<Integer>();
        temp4.add(4);
        temp4.add(1);
        temp4.add(8);
        temp4.add(3);
        tri.add(temp4);
        int res=triangle.minimumTotal(tri);
        System.out.println(res);
    }
}
