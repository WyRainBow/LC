package LC49;

import java.util.*;
import java.util.HashMap;

public class Demo {

    public static void main(String[] args) {
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] charArray=str.toCharArray();
            Arrays.sort(charArray);
            String key=new String(charArray);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }

        //map变成list
        List<List<String>> res=new ArrayList<>();
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            res.add(entry.getValue());
        }
        System.out.println(res);
    }

}
