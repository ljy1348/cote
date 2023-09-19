class Solution {
    public String solution(String code) {
        String answer = "";
        boolean mode = false;
        for (int i = 0; i < code.length(); i++) {
            char cha = code.charAt(i);
            if (cha == '1' && mode == false) {mode = true; continue;}
            else if (cha == '1' && mode == true) {mode = false; continue;}
            if (mode == false && i%2 == 0) {
                answer += String.valueOf(cha);
            } else if (mode == true && i%2 == 1) {
                answer += String.valueOf(cha);
            }
            // System.out.println(mode);
        }
        if (answer.equals("")) answer = "EMPTY";
        
        return answer;
    }
}