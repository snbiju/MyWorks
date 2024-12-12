package com.app.test.trans;

import java.util.*;

public class Parentheses {
    public static boolean isValid(String s){
        char [] charArray = s.toCharArray();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');

        Deque<Character> stack = new ArrayDeque<>();

        for (Character c:charArray
             ) {
            if(map.containsKey(c)){
                stack.push(c);
            }else if(map.containsValue(c)){
                if(!stack.isEmpty() && Objects.equals(map.get(stack.peek()), c)){
                    stack.pop();
                }else {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(isValid("{{[]}}"));
        System.out.println(isValid("{{[(hello)]}}"));
        System.out.println(isValid("{{[}}"));
    }
}
