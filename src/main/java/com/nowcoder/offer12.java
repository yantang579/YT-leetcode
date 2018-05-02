package com.nowcoder;

/**
 * Created by lqy on 2018/3/5.
 */
public class offer12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(rows<1||cols<1||str.length==0||matrix.length==0){
            return false;
        }
        boolean[] visited=new boolean[matrix.length];
        for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }

        int pathLength=0;
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(hasPathCore(matrix,rows,cols,row,col,str,pathLength,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPathCore(char[] matrix,int rows,int cols,int row,int col,char[] str,int pathLength,boolean[] visited){
        if(str.length==pathLength-1){
            return true;
        }
        boolean hasPath=false;
        if(row>=0 && row<rows && col>=0 && col<cols && matrix[row*cols+col]==str[pathLength]){
            pathLength++;
            visited[row*cols+col]=true;
            hasPath=hasPathCore(matrix,rows,cols,row,col-1,str,pathLength,visited)||
                    hasPathCore(matrix,rows,cols,row,col+1,str,pathLength,visited)||
                    hasPathCore(matrix,rows,cols,row-1,col,str,pathLength,visited)||
                    hasPathCore(matrix,rows,cols,row+1,col,str,pathLength,visited);
            if(!hasPath){
                pathLength--;
                visited[row*cols+col]=false;
            }

        }
        return hasPath;
    }
}
