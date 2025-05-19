package LC20;

import java.util.HashMap;
import java.util.Stack;

public class Demo0519 {


    public static void main(String[] args) {

        String s = "()";
        boolean valid = isValid(s);
        System.out.println(valid);
    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);


            //如果是左括号就入栈
            if (map.containsValue(c)) {
                stack.push(c);
            } else if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }


}
