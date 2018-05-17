package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/15.
 * <p>
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {
    int[][] d=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (existHelper(board, word, i, j, 0, visited) == true) return true;
            }
        }
        return false;
    }

    /**
     *
     * @param board 二维字母矩阵
     * @param word 单词
     * @param row 字母矩阵当前的行
     * @param col 字母矩阵当前的列
     * @param index 单词的第几个字母
     * @param visited
     * @return
     */
    private boolean existHelper(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length()-1) return board[row][col]==word.charAt(index);
        if (board[row][col] == word.charAt(index)) {
            visited[row][col] = true;
            for(int i=0;i<4;i++){
                int newx=row+d[i][0];
                int newy=col+d[i][1];
                if(inArea(board,newx,newy) && !visited[newx][newy])
                    if(existHelper(board,word,newx,newy,index+1,visited))
                        return true;
            }
            visited[row][col]=false;
        }
        return false;
    }
    private boolean inArea(char[][] board,int x,int y){
        if(x>=0 && x<board.length && y>=0 && y<board[0].length) return true;
        return false;
    }
}
