package com.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lqy on 2018/5/17.
 * <p>
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * A sudoku solution must satisfy all of the following rules:
 * <p>
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 * <p>
 * <p>
 * A sudoku puzzle...
 * <p>
 * <p>
 * ...and its solution numbers marked in red.
 * <p>
 * Note:
 * <p>
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique solution.
 * The given board size is always 9x9.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        List<List<Integer>> blanks=new ArrayList<List<Integer>>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    List<Integer> temp=new ArrayList<Integer>();
                    temp.add(i);
                    temp.add(j);
                    blanks.add(temp);
                }

            }
        }
        putNumber(0,board,blanks);
        return;
    }
    private boolean putNumber(int index,char[][] board,List<List<Integer>> blanks){
        if (board == null || board.length == 0) {
            return false;
        }
        for(int blank=index;blank<blanks.size();blank++){
            int i=blanks.get(blank).get(0);
            int j=blanks.get(blank).get(1);
            for(char k = '1'; k <= '9'; k++) {
                if (check(board, i, j, k) == true) {
                    board[i][j] = k;
                    if(putNumber(index + 1, board, blanks)) return true;
                    else
                        board[i][j] = '.';

                }
            }
            return false;
        }
        return true;
    }

    /**
     *
     * @param board 数独表
     * @param row 当前行
     * @param col 当前列
     * @param k 当前位置填的数字
     * @return
     */
    private boolean check(char[][] board,int row,int col,char k){
        boolean[] rows=new boolean[9];
        boolean[] cols=new boolean[9];
        boolean[] boards=new boolean[9];
        //判断行
        for(int i=0;i<board.length;i++){
            if(board[row][i]==k) return false;
        }
        //判断列
        for(int i=0;i<board[0].length;i++){
            if(board[i][col]==k) return false;
        }
        //判断3*3表格'
        for(int i=row/3*3;i<row/3*3+3;i++){
            for(int j=col/3*3;j<col/3*3+3;j++){
                if(board[i][j]==k) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board1=new char[][]{
                {'5','3','1'},
                {'6','.','.'},
                {'.','9','8'}
        };
        char[][] board=new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        SudokuSolver sudokuSolver=new SudokuSolver();
        sudokuSolver.solveSudoku(board);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
