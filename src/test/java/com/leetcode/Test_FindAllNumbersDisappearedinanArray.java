package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import com.leetcode.easy.FindAllNumbersDisappearedinanArray;

/**
 * Created by lqy on 2017/11/23.
 */
public class Test_FindAllNumbersDisappearedinanArray {
    public static void main(String args[]){
        int[] array=new int[]{1,1};
        List<Integer> res=new ArrayList<Integer>();
        FindAllNumbersDisappearedinanArray test= new FindAllNumbersDisappearedinanArray();
        res=test.findDisappearedNumbers(array);
        System.out.println(res);
    }
}
