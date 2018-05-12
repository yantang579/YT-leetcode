package com.leetcode;
import com.leetcode.easy.MaximumAverageSubarrayI;


/**
 * Created by lqy on 2017/11/24.
 *
 */
public class Test_MaximumAverageSubarrayI {
    public static void main(String args[]){
        int[] array=new int[]{0,1,1,3,3};
        int k=4;
        MaximumAverageSubarrayI test= new MaximumAverageSubarrayI();
        test.findMaxAverage2(array,k);
    }
}
