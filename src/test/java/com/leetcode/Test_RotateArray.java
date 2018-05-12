package com.leetcode;
import com.leetcode.easy.RotateArray;

/**
 * Created by lqy on 2017/11/22.
 */
public class Test_RotateArray {
    public static void main(String args[]){
        int[] array=new int[]{1,2,3,4,5,6,7};
        RotateArray test=new RotateArray();
        test.rotate3(array,8);
        for(int i:array){
            System.out.print(i+" ");
        }
    }
}
