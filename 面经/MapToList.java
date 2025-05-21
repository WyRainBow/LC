package 面经;




//将 Map 转换为 List
import java.util.*;

public class MapToList {
    public static List<Integer> mapToList(Map<String, Integer> map) {

        List<Integer> res = new ArrayList<>();
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 5);
        map.put("banana", 3);
        map.put("orange", 7);

        List<Integer> result = mapToList(map);
        for (Integer value : result) {
            System.out.println(value);
        }
    }
}