package com.leetcode;
import com.leetcode.easy.KdiffPairsinanArray;
/**
 * Created by lqy on 2017/11/23.
 */
public class Test_KdiffPairsinanArray {
    public static void main(String args[]){
        int[] array=new int[]{3,1,4,1,5};
        KdiffPairsinanArray test=new KdiffPairsinanArray();
        int res=test.findPairs2(array,2);
        System.out.println(res);
    }


}
