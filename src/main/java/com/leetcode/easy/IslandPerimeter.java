package com.leetcode.easy;

/**
 * Created by lqy on 2017/11/29.
 * <p>
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water,
 * and there is exactly one island(i.e., one or more connected land cells).
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int res = 0, count = 4;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count = gridEdge(grid, i, j);
                    res += count;
                }
            }
        }
        return res;
    }

    int gridEdge(int[][] grid, int i, int j) {
        int count = 4;
        int row = grid.length;
        int col = grid[0].length;
        if (i - 1 >= 0 && grid[i - 1][j] == 1) count--;
        if (i + 1 < row && grid[i + 1][j] == 1) count--;
        if (j - 1 >= 0 && grid[i][j - 1] == 1) count--;
        if (j + 1 < col && grid[i][j + 1] == 1) count--;
        return count;
    }
}
