package com.leetcode.easy;

import com.leetcode.classes.Employee;

import java.util.*;

/**
 * Created by lqy on 2017/11/30.
 * <p>
 * You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.
 * <p>
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.
 * <p>
 * Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.
 * <p>
 * Example 1:
 * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * Output: 11
 * Explanation:
 * Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 * Note:
 * One employee has at most one direct leader and may have several subordinates.
 * The maximum number of employees won't exceed 2000.
 */
/*
// Employee info
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
public class EmployeeImportance {
    /**
     * 使用了map和queue
     * 首先将List<Employee>放入map中，可以通过id获取empplyee
     * 然后将当前要获取的id的employee放入队列
     * 遍历队列，将队列中employee的subordinates放入队列
     * 用的树的层次遍历方法。
     * @param employees
     * @param id
     * @return
     */
    public int getImportance(List<Employee> employees, int id) {
        int total=0;
        Map<Integer,Employee> map= new HashMap<Integer, Employee>();
        for(Employee em:employees){
            map.put(em.id,em);
        }
        Queue<Employee> qu=new LinkedList<Employee>();
        qu.offer(map.get(id));
        while(!qu.isEmpty()){
            Employee current=qu.poll();
            total+=current.importance;
            for(Integer i:current.subordinates){
                qu.offer(map.get(i));
            }
        }
        return total;
    }
}
