import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack();
        
        for (int a : arr) {
            if (stack.isEmpty()) {
                stack.add(a);
            }
            else if (stack.peek() != a) {
                stack.add(a);
            }
        }
        
        int[] result = stackToArray(stack);
        
        return result;
    }
    
    public int[] stackToArray(Stack<Integer> stack) {
        int[] result = new int[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[index] = stack.pop();
            index--;
        }
        return result;
    }
}