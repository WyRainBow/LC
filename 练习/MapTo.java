package 练习;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 5);
        map.put("banana", 3);
        map.put("orange", 7);

        for(Map.Entry<String,Integer>entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
