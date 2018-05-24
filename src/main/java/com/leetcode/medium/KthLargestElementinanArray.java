package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/24.
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementinanArray {
    /**
     * 利用快排partition中，将pivot放置在正确的位置上的性质
     * 在O(n)时间复杂度完成
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        int position=n-k;//第k大的数字在有序的nums中的index
        return quickSort(nums,0,n-1,position);
    }
    private int quickSort(int[] nums,int low,int high,int position){
        if(low<high){
            int middle=getmiddle(nums,low,high);
            if(middle<position) return quickSort(nums,middle+1,high,position);
            else if(middle>position)  return quickSort(nums,low,middle-1,position);
            else return nums[middle];
        }
        return nums[low];
    }
    private int getmiddle(int[] nums,int low,int high){
        int key=nums[low];
        while(low<high){
            while(low<high&& nums[high]>=key) high--;
            nums[low]=nums[high];
            while(low<high && nums[low]<=key) low++;
            nums[high]=nums[low];
        }
        nums[low]=key;
        return low;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{3,2,1,5,6,4};
        KthLargestElementinanArray test=new KthLargestElementinanArray();
        System.out.println(test.findKthLargest(nums,2));
    }
}
