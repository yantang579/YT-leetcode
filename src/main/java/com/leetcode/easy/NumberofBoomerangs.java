package com.leetcode.easy;

/**
 * Created by lqy on 2017/11/28.
 * <p>
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * <p>
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 * <p>
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 解题思路：
 * 如果有a,b,c三个点，b,c两个点到a的距离相等，则有(a,b,c)和(a,c,b)两种组合
 * 如果有a,b,c,d四个点，b,c,d三个点到a的距离相等，则有(a,b,c),(a,c,b),(a,c,d),(a,d,c),(a,b,d),(a,d,b)六种组合
 * 所有，如果有n个点，到a的距离相等，则有n*(n-1)种组合
 *
 * 遍历points数组，将每个点作为a，然后计算其余各点到a的距离。如果相等的点个数>=2，则计算res+=n*(n-1)
 *
 */
public class NumberofBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        Map<Double,Integer> map = new HashMap<Double, Integer>();
        int res=0;
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points.length;j++){
                double dist=Math.pow(points[i][0]-points[j][0],2)+Math.pow(points[i][1]-points[j][1],2);
                if(map.containsKey(dist))
                    map.put(dist,map.get(dist)+1);
                else
                    map.put(dist,1);

            }
            for(Map.Entry entry:map.entrySet()){
                int n=(Integer) entry.getValue();
                if(n>=2) res+=n*(n-1);
            }
            map.clear();
        }
        return res;
    }
}
