///////////////////////////////////////////
//20. Valid Parentheses
///////////////////////////////////////////

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        
         for(int i =0; i<s.length(); i++) {
             
             char ch = s.charAt(i);
             
             if(ch == '(' || ch == '{' || ch == '[' ) {
                 stack.push(ch);
             } else {
                  if(ch == ')'){
                      if(stack.isEmpty()) {
                          return false;
                      }
                      else if(stack.peek()!='(') {
                          return false;
                      } else {
                          stack.pop();
                      }
                  } else if(ch == '}'){
                      if(stack.isEmpty()) {
                          return false;
                      }
                      else if(stack.peek()!='{') {
                          return false;
                      } else {
                          stack.pop();
                      }
                  } else if(ch == ']'){
                      if(stack.isEmpty()) {
                          return false;
                      }
                      else if(stack.peek()!='[') {
                          return false;
                      } else {
                          stack.pop();
                      }
                  }
             }
             
         }
        
        return stack.isEmpty();
        
    }
}