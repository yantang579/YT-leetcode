package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/22.
 * <p>
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
 * <p>
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 * <p>
 * Examples:
 * Input:
 * letters = ["c", "f", "j"]
 * target = "a"
 * Output: "c"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "c"
 * Output: "f"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "g"
 * Output: "j"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "j"
 * Output: "c"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 * Note:
 * letters has a length in range [2, 10000].
 * letters consists of lowercase letters, and contains at least 2 unique letters.
 * target is a lowercase letter.
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        char res=0;
        if(target>=letters[letters.length-1]) return letters[0];
        else if(target<letters[0]) return letters[0];
        else{
            int low=0,high=letters.length;
            int middle=(high-low)/2+low;
            while(low<high){
                if(letters[middle]<=target) low=middle+1;
                else high=middle;
                middle=(high-low)/2+low;
            }
            res=letters[high];
        }
        return res;
    }
}
