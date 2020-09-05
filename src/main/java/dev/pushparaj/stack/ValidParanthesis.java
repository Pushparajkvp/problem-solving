package dev.pushparaj.stack;

import java.util.*;

class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int it=0; it<s.length(); it++) {
            char chr = s.charAt(it);
            
            switch(chr) {
                case ')' : 
                    if(stack.isEmpty() || stack.peek() != '(')
                        return false;
                    stack.pop();
                    break;
                case '}' :
                    if(stack.isEmpty() || stack.peek() != '{')
                        return false;
                    stack.pop();
                    break;
                case ']' :
                    if(stack.isEmpty() || stack.peek() != '[')
                        return false;
                    stack.pop();
                    break;
                default:
                    stack.push(chr);
            }
            
        }
        
        return stack.size() == 0;
    }
}