package com.leetcode.easy;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by lqy on 2017/11/29.
 * <p>
 * Given a List of words,
 * return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.(键盘)
 * Example 1:
 *      Input: ["Hello", "Alaska", "Dad", "Peace"]
 *      Output: ["Alaska", "Dad"]
 * Note:
 *      You may use one character in the keyboard more than once.
 *      You may assume the input string will only contain letters of alphabet.
 */
public class KeyboardRow {
    public String[] findWords(String[] words){
        String[] keyboard=new String[]{"qwertyuiop","asdfghjkl","zxcvbnm"};
        List<String> res=new ArrayList<String>();
        String[] resString;
        int index=-1;//第一个字母属于哪一行
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                if(j==0){
                    for(int k=0;k<3;k++){
                        if(keyboard[k].contains(String.valueOf(words[i].toLowerCase().charAt(j)))){
                            index=k;
                            break;
                        }
                    }
                }
                if(!keyboard[index].contains(String.valueOf(words[i].toLowerCase().charAt(j)))){
                    index=-1;
                    break;
                }
            }
            if(index!=-1){
                res.add(words[i]);
            }
        }
        resString =res.toArray(new String[res.size()]);
        return resString;
    }

    /**
     * 方法和上面那个是一样的，但是这个代码更简洁
     * @param words
     * @return
     */
    public String[] findWords2(String[] words) {

        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i<strs.length; i++){
            for(char c: strs[i].toCharArray()){
                map.put(c, i);//put <char, rowIndex> pair into the map
            }
        }
        List<String> res = new LinkedList<String>();
        for(String w: words){
            int index = map.get(w.toUpperCase().charAt(0));
            for(char c: w.toUpperCase().toCharArray()){
                if(map.get(c)!=index){
                    index = -1; //don't need a boolean flag.
                    break;
                }
            }
            if(index!=-1) res.add(w);//if index != -1, this is a valid string
        }
        return res.toArray(new String[res.size()]);
    }
}
