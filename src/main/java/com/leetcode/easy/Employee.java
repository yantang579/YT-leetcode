package com.leetcode.easy;

import java.util.List;

/**
 * Created by lqy on 2017/11/30.
 */
public class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
/*
    public int getId(){
        return this.id;
    }
    public int getImportance(){
        return this.importance;
    }
    public int getSubLen(){
        return subordinates.size();
    }
    public List<Integer> getSubordinates(){
        return this.subordinates;
    }
    */

}
