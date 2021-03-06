package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/24.
 * <p>
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height==null||height.length==0) return 0;
        int left=0,right=height.length-1;
        int lmax=height[left];
        int rmax=height[right];
        int maxArea=0;
        while(right>left){
            if(lmax>rmax){
                maxArea=Math.max(maxArea,rmax*(right-left));
                right--;
                rmax=Math.max(rmax,height[right]);
            } else {
                maxArea=Math.max(maxArea,lmax*(right-left));
                left++;
                lmax=Math.max(lmax,height[left]);
            }
        }
        return maxArea;
    }
}
