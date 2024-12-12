package com.app.codes.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String str){
        Map<Character,Character> parenthesesMap = new HashMap<>();
        parenthesesMap.put('(',')');
        parenthesesMap.put('{','}');
        parenthesesMap.put('[',']');
        Stack<Character> stack = new Stack<>();

        for (Character c: str.toCharArray()){
            if(parenthesesMap.containsKey(c)){
                stack.push(c);
            }else if(parenthesesMap.containsValue(c)){
                if(!stack.isEmpty() && parenthesesMap.get(stack.peek())==c){
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
