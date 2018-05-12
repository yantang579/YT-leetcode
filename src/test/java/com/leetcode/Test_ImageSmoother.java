package com.leetcode;
import com.leetcode.easy.ImageSmoother;
/**
 * Created by lqy on 2017/11/27.
 */
public class Test_ImageSmoother {
    public static void main(String args[]){
        int[][] M=new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        ImageSmoother test=new ImageSmoother();
        int [][] res=new int[3][3];
        res=test.imageSmoother(M);
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}
