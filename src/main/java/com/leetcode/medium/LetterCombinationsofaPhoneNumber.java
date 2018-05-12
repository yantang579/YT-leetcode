package com.leetcode.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lqy on 2018/5/9.
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsofaPhoneNumber {
    Map<Integer,String> map=new HashMap<Integer, String>();
    public List<String> letterCombinations(String digits) {
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        ArrayList<String> list=new ArrayList<String>();
        if(digits==null||digits.length()==0) return list;
        letterCombinationsHelper(digits,0,new StringBuilder(),list);
        return list;
    }
    public void letterCombinationsHelper(String digits,int index,StringBuilder sb,ArrayList<String> list){
        if(index==digits.length()){
            list.add(sb.toString());
            return ;
        }
        char c=digits.charAt(index);
        String keyboard=map.get(c-'0');
        for(int i=0;i<keyboard.length();i++){
            StringBuilder temp=new StringBuilder(sb);
            temp.append(keyboard.charAt(i));
            letterCombinationsHelper(digits,index+1,temp,list);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber temp=new LetterCombinationsofaPhoneNumber();
        System.out.println(temp.letterCombinations("23"));
    }

}
