import java.util.Arrays;
class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        char[] cha = my_string.toCharArray();
        char temp = cha[num1];
        cha[num1] = cha[num2];
        cha[num2] = temp;
        answer = new String(cha);
        return answer;
    }
}