package com.leetcode.easy;

/**
 * Created by lqy on 2017/11/24.
 * <p>
 * Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.
 * <p>
 * Example 1:
 * Input:
 * [[1,1,1],
 * [1,0,1],
 * [1,1,1]]
 * Output:
 * [[0, 0, 0],
 * [0, 0, 0],
 * [0, 0, 0]]
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * Note:
 * The value in the given matrix is in the range of [0, 255].
 * The length and width of the given matrix are in the range of [1, 150].
 *
 * 解析：
 * 申请一个同等大小的矩阵，
 * 然后双重for循环，判断每一个元素的周围及自身共9个元素
 * 针对每一个元素，自身的row，col + {-1,0,1}可以得到9个元素的坐标
 * isValid判断这9个坐标是否合理
 * 如果合理才增加count，增加sum
 */
public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length == 0) return null;
        int rows = M.length;
        int cols = M[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int count = 0;
                int sum = 0;
                for (int x : new int[]{-1, 0, 1}) {
                    for (int y : new int[]{-1, 0, 1}) {
                        if (isValid(i + x, j + y, rows, cols)) {
                            count++;
                            sum += M[i + x][j + y];
                        }
                    }
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }

    public boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}

