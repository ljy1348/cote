import java.util.Arrays;
class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i = 0; i < quiz.length; i++) {
            String[] copy = quiz[i].split(" ");
            int a = Integer.parseInt(copy[0]);
            int b = Integer.parseInt(copy[2]);
            int c = Integer.parseInt(copy[4]);
            if (copy[1].equals("-")) {
                if (a - b == c) {
                    answer[i] = "O";
                } else {
                    answer[i] = "X";
                }
            } else if (copy[1].equals("+")) {
                if (a + b == c) {
                    answer[i] = "O";
                } else {
                    answer[i] = "X";
                }
            }
        }
        
        
        
        
        return answer;
    }
}