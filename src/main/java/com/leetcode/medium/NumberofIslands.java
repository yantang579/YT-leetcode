package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/16.
 * <p>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */
public class NumberofIslands {
    int[][] d=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0) return 0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    numIslandsHelper(grid,i,j,visited);
                    count++;
                }

            }
        }
        return count;
    }
    private void numIslandsHelper(char[][] grid,int x,int y,boolean[][] visited){
        for(int i=0;i<=3;i++){
            visited[x][y]=true;
            int newX=x+d[i][0];
            int newY=y+d[i][1];
            if(inArea(grid,newX,newY) && visited[newX][newY]==false && grid[newX][newY]=='1'){
                numIslandsHelper(grid,newX,newY,visited);
            }
        }

        return;
    }
    private boolean inArea(char[][] board,int x,int y){
        if(x>=0 && x<board.length && y>=0 && y<board[0].length) return true;
        return false;
    }
    public static void main(String[] args) {
        char[][] grid=new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        NumberofIslands numberofIslands=new NumberofIslands();
        System.out.println(numberofIslands.numIslands(grid));
    }
}
