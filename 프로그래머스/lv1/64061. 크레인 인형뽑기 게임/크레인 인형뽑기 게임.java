import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][moves[i]-1] != 0) {
                    if (stk.size() > 0 ) {
                        if (board[j][moves[i]-1] == stk.peek()) {
                            System.out.println(stk.peek());
                        stk.pop();
                            board[j][moves[i]-1] = 0;
                        answer += 2;
                        break;
                        }else {
                        stk.push(board[j][moves[i]-1]);
                            System.out.println(stk.peek());
                        board[j][moves[i]-1] = 0;
                        break;
                }
                    }
                    else {
                        stk.push(board[j][moves[i]-1]);
                        System.out.println(stk.peek());
                        board[j][moves[i]-1] = 0;
                        break;
                }
            }
               
        }
        }
        return answer;
    }
}