import java.util.Arrays;
class Solution {
    public String solution(String my_string) {
        my_string = my_string.toLowerCase();
        char[] cha = my_string.toCharArray();
        Arrays.sort(cha);
        String answer = new String(cha);
        return answer;
    }
}