package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * Example:
 *
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIPAddresses {
    List<String> res=new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {
        if(s==null||s.length()==0) return res;
        if(s.length()>12) return res;
        restoreIpAddressHelper(s,0,1,new StringBuilder());
        return res;
    }
    private void restoreIpAddressHelper(String s,int index,int n,StringBuilder sb){
        if(n==4){
            String temp=s.substring(index,s.length());
            if(temp.charAt(0)=='0' && temp.length()!=1) return;

            if(Long.valueOf(temp)<=255&& Long.valueOf(temp)>=0) {
                sb.append(s.substring(index,s.length()));
                res.add(sb.toString());
            }
            return ;
        }
        for(int i=1;i<=3 && index+i<s.length();i++){//表示0-255
            String temp=s.substring(index,index+i);
            if(temp.charAt(0)=='0' &&temp.length()!=1) break;
            if(Integer.valueOf(s.substring(index,index+i))<=255){
                StringBuilder sb1=new StringBuilder(sb);
                sb1.append(s.substring(index,index+i));
                sb1.append(".");
                restoreIpAddressHelper(s,index+i,n+1,sb1);
            }
        }
    }

    public static void main(String[] args) {
        RestoreIPAddresses restoreIPAddresses=new RestoreIPAddresses();
        System.out.println(restoreIPAddresses.restoreIpAddresses("010010"));
    }
}
