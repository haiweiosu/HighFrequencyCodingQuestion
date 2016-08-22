public class Solution {
    public int evalRPN(String[] tokens) {        
        /* We use stack to store the number and operator */
        
        int result = 0;
        
        String operator = "+-*/";
        
        Stack<String> stack = new Stack<>();
        
        for (String s: tokens) {
            if(!operator.contains(s)){
                stack.push(s);
            }
            else{
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                
                int index = operator.indexOf(s);
                
                switch(index){
                    case 0: 
                        stack.push(String.valueOf(a+b));
                        break;
                    case 1: 
                        stack.push(String.valueOf(b-a));
                        break;
                    case 2: 
                        stack.push(String.valueOf(a*b));
                        break;
                    case 3: 
                        stack.push(String.valueOf(b/a));
                        break;
                }
            }
        }
        
        result = Integer.valueOf(stack.pop());
        
        return result;
    }
}