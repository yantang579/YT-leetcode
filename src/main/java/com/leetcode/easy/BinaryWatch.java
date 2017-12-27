package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lqy on 2017/12/25.
 * <p>
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the right.
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
 * <p>
 * Example:
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * <p>
 * Note:
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 */
public class BinaryWatch {
    /**
     * Straightforward Solution
     *
     * @param num
     * @return
     */
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    res.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return res;
    }

    /**
     * Backtracking Solution
     *
     * @param num
     * @return
     */
    public List<String> readBinaryWatch2(int num) {
        int hours[] = {8, 4, 2, 1};
        int minutes[] = {32, 16, 8, 4, 2, 1};
        List<String> res = new ArrayList<String>();
        for (int i = 0; i <= num; i++) {
            List<Integer> list1 = generateNumbers(hours, i);
            List<Integer> list2 = generateNumbers(minutes, num-i);
            for (int hour : list1) {
                if (hour >= 12) continue;
                for (int min : list2) {
                    if (min >= 60) continue;
                    res.add(hour + ":" + (min >= 10 ? min : "0" + min));
                }
            }
        }
        return res;
    }

    public List<Integer> generateNumbers(int nums[], int count) {
        List<Integer> res = new ArrayList<Integer>();
        generateDigitHelper(nums, count, 0, 0, res);
        return res;
    }
    public void generateDigitHelper(int nums[],int count,int pos,int sum,List<Integer> res){
        if(count == 0) {
            res.add(sum);
            return;
        }

        for(int i = pos; i < nums.length; i++) {
            generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);
        }
    }
}
