package com.leetcode.easy;

/**
 * Created by lqy on 2018/1/4.
 * <p>
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 * <p>
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 * <p>
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
 * <p>
 * At the end, return the modified image.
 * <p>
 * Example 1:
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 * Note:
 * <p>
 * The length of image and image[0] will be in the range [1, 50].
 * The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0) return image;
        if (sr > image.length - 1 || sc > image[0].length - 1) return image;
        if (image[sr][sc]==newColor)return image;
        floodFillHelper(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public void floodFillHelper(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0 ||image[sr][sc]!=oldColor) return ;
        image[sr][sc]=newColor;
        floodFillHelper(image,sr+1,sc,oldColor,newColor);
        floodFillHelper(image,sr-1,sc,oldColor,newColor);
        floodFillHelper(image,sr,sc+1,oldColor,newColor);
        floodFillHelper(image,sr,sc-1,oldColor,newColor);
    }
}
