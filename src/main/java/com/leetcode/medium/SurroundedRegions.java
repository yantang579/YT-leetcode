package com.leetcode.medium;

/**
 * Created by lqy on 2018/5/17.
 * <p>
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Example:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 * <p>
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions {
    int[][] d=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public void solve(char[][] board) {
        if(board==null||board.length<=1||board[0].length<=1) return ;
        boolean[][] visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O') flipping(board,i,0);
            if(board[i][board[0].length-1]=='O') flipping(board,i,board[0].length-1);
        }
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O' ) flipping(board,0,i);
            if(board[board.length-1][i]=='O') flipping(board,board.length-1,i);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='F') board[i][j]='O';
            }
        }
        return;
    }
    private void flipping(char[][] board,int row,int col){
        if(board[row][col]=='X') return;
        board[row][col]='F';
        for(int i=0;i<=3;i++){
            int newrow=row+d[i][0];
            int newcol=col+d[i][1];
            if(inArea(board,newrow,newcol) && board[newrow][newcol]=='O') flipping(board,newrow,newcol);
        }

    }
    private boolean inArea(char[][] board,int x,int y){
        if(x>=0 && x<board.length && y>=0 && y<board[0].length) return true;
        return false;
    }

    public static void main(String[] args) {
        char[][] board=new char[][]{{'O','X','X','O','X'},{'X','X','X','X','O'},{'X','X','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        SurroundedRegions surroundedRegions=new SurroundedRegions();
        surroundedRegions.solve(board);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println(" ");
        }

    }
}
