import java.util.Arrays;
class Solution {
    public String[] solution(String myString) {
        myString = myString.replaceAll("x{1,}"," ");
        myString = myString.trim();
        String[] answer = myString.split(" ");
        Arrays.sort(answer);
        return answer;
    }
}