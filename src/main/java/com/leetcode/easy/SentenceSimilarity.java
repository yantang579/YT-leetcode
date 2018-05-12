package com.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lqy on 2017/12/3.
 * <p>
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.
 * <p>
 * For example, "great acting skills" and "fine drama talent" are similar, if the similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].
 * <p>
 * Note that the similarity relation is not transitive. For example, if "great" and "fine" are similar, and "fine" and "good" are similar, "great" and "good" are not necessarily similar.
 * <p>
 * However, similarity is symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.
 * <p>
 * Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.
 * <p>
 * Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].
 * <p>
 * Note:
 * <p>
 * The length of words1 and words2 will not exceed 1000.
 * The length of pairs will not exceed 2000.
 * The length of each pairs[i] will be 2.
 * The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 */
public class SentenceSimilarity {
    /**
     * 需要注意的是，pairs中可能会出现这样的情况：
     * "good"->"excellent"
     * "good"->"great"
     * 因此应该设计Map<String,Set<String>
     *     而不是Map<String,String>
     * @param words1
     * @param words2
     * @param pairs
     * @return
     */
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        boolean res = true;

        for (String[] pair : pairs) {
            if (!map.containsKey(pair[0])) map.put(pair[0], new HashSet<String>());
            if (!map.containsKey(pair[1])) map.put(pair[1], new HashSet<String>());
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }

        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i]) &&
                    !map.getOrDefault(words1[i], new HashSet<String>()).contains(words2[i]) &&
                    !map.getOrDefault(words2[i], new HashSet<String>()).contains(words1[i]))
                return false;
        }
        return true;
    }
}
