class Solution {
    public String solution(String my_string) {
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            char cha = my_string.charAt(i);
            if (cha >= 'a' && cha <='z') cha = (char)(cha-'a'+'A');
            else if (cha >= 'A' && cha <='Z') cha = (char)(cha-'A'+'a');
            answer += cha;
        }
        return answer;
    }
}