class Solution {
    public String solution(int age) {
        String answer = "";
        String num = String.valueOf(age);
        for (int i = 0; i < num.length(); i++) {
            answer += (char)(Integer.valueOf(num.charAt(i)-'0')+'a');
        }
        
        return answer;
    }
}