class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        for(int i=0 ; i < tokens.length; i++) {
            if(operands.size()<2 && (tokens[i].equals("+") || tokens[i].equals("-") ||  tokens[i].equals("*") || tokens[i].equals("/") )) {
                return -101;
            }
            else if( tokens[i].equals("+")) {
                operands.push(operands.pop() + operands.pop());     
            }
            else if( tokens[i].equals("-") ) { 
                int a = operands.pop();
                int b = operands.pop();
                operands.push( b-a);   
            }
            else if( tokens[i].equals("*") ) { 
                operands.push(operands.pop()*operands.pop());
            }
            else if( tokens[i].equals("/") ){
                int a = operands.pop();
                int b = operands.pop();
                operands.push( b/a); 
            }
            else {
                operands.push(Integer.parseInt(tokens[i]));
            }

        } 
        return operands.pop();    
    }
}
