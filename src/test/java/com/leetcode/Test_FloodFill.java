package com.leetcode;

import com.leetcode.easy.FloodFill;

/**
 * Created by lqy on 2018/1/4.
 */
public class Test_FloodFill {
    public static void main(String[] args){
        FloodFill test= new FloodFill();
        int[][] image={{1,1,1},{1,1,0},{1,0,1}};
        test.floodFill(image,1,1,2);
    }
}
