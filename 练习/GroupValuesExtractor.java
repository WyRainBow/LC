package 练习;
import java.util.*;
public class GroupValuesExtractor {

    /**
     * 将 Map 转换为 List<List<String>>
     * @param map
     * @return
     */

    public static List<List<String>> mapToList(Map<String, List<String>> map) {

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("group1", Arrays.asList("apple", "banana"));
        map.put("group2", Arrays.asList("carrot", "spinach"));

        List<List<String>> result = mapToList(map);
        for (List<String> list : result) {
            System.out.println(list);
        }
        System.out.println();
        System.out.println(result);
    }
}