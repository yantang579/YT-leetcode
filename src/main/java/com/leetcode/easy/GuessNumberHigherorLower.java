package com.leetcode.easy;

/**
 * Created by lqy on 2017/12/8.
 * <p>
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * <p>
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * <p>
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 * Example:
 * n = 10, I pick 6.
 * <p>
 * Return 6.
 */

/*
  The guess API is defined in the parent class GuessGame.
  @param num, your guess
  @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
  int guess(int num);
 */
public class GuessNumberHigherorLower {
    /**
     * Time Limit Exceeded???
     *
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = (low + high) / 2;//Do NOT use (low+high)/2 in case of over flow
            if (guess(mid) == -1)
                high = mid - 1;
            else if (guess(mid) == 1)
                low = mid + 1;
            else return mid;
        }
        return -1;
    }

    public int guessNumber2(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (guess(mid) == -1)
                high = mid - 1;
            else if (guess(mid) == 1)
                low = mid + 1;
            else return mid;
        }
        return low;
    }

    public int guess(int num) {
        return 0;
    }
}
