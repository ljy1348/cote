import java.util.Stack;
class Solution {
    public Integer[] solution(int[] arr, boolean[] flag) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                for (int j = 0; j < arr[i]*2; j++) {
                    stk.push(arr[i]);
                    // System.out.println(stk.peek());
                }
            } else {
                for (int j = 0; j < arr[i]; j++) {
                    stk.pop();
                }
            }
        }
        // System.out.println(stk.size());
        // int[] answer = new int[stk.size()];
        Integer[] answer = stk.toArray(new Integer[stk.size()]);
        return answer;
    }
}