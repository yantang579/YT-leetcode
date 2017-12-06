package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/6.
 * <p>
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 */

/**
 * 罗马数字有如下符号：

 基本字符	        I	V	X	L	C	D	M
 对应阿拉伯数字	1	5	10	50	100	500	1000

 计数规则：
 相同的数字连写，所表示的数等于这些数字相加得到的数，例如：III = 3
 小的数字在大的数字右边，所表示的数等于这些数字相加得到的数，例如：VIII = 8
 小的数字，限于（I、X和C）在大的数字左边，所表示的数等于大数减去小数所得的数，例如：IV = 4
 正常使用时，连续的数字重复不得超过三次
 在一个数的上面画横线，表示这个数扩大1000倍（本题只考虑3999以内的数，所以用不到这条规则）
 */
public class RomantoInteger {
    public int romanToInt(String s) {
        int res=0;
        if(s.length()==0) return 0;
        int i=0,len=s.length();
        char c,pre_c=0;
        while(i<s.length()){
            c=s.charAt(i);
            if(i==0){
                res+=getData(c);
            }
            else {
                if(getData(c)>getData(pre_c))
                    res=res-2*getData(pre_c);
                res+=getData(c);
            }
            i++;
            pre_c=c;
        }
        return res;
    }
    public int getData(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
