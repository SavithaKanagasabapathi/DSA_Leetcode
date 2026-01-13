class Solution {
    public int evalRPN(String[] tokens) {
        //TC-O(n) and SC-O(n), in worst case if operator is at last, need to insert n in stack
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if ("+-*/".contains(token) && token.length() == 1) {//If -ve num came, 
                //it should not be considered, so length should be 1 
                int b = stack.pop(); //Top first num should be b
                int a = stack.pop(); //Only pop first 2 
                stack.push(switch (token) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default -> 0;
                });
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}