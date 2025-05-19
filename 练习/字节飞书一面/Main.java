package 练习.字节飞书一面;

import java.util.*;
public class Main {
    public static void main(String[] args) {

        String s="abc";
        char[] str=s.toCharArray();
        String[] ss=new String[str.length];
        for(int i=0;i<str.length;i++){
            ss[i]=String.valueOf(str[i]);
        }
        List<List<String>> result=new ArrayList<>();
        result=per(ss);
        System.out.println(result);
    }

    public static List<List<String>> per(String[] s){
        int len=s.length;
        List<List<String>> res=new ArrayList<>();
        if(len==0){
            return res;
        }
        boolean[] used=new boolean[len];
        List<String> path=new ArrayList<>();
        dfs(s,len,0,path,used,res);

        return res;
    }


    public static void dfs(String[] s,int len,int depth,List<String> path,boolean[] used,List<List<String>> res){
        if(depth==len){
            res.add(path);
            return;
        }

        for(int i=0;i<len;i++){
            if(!used[i]){
                path.add(s[i]);
                used[i]=true;
                dfs(s,len,depth+1,path,used,res);
                used[i]=false;
                path.remove(path.size()-1);
            }
        }
    }
}