import java.util.Arrays;
class Solution {
    public int[] solution(int n) {
        String result = "";
        for (int i = 1; i <= n ; i++) {
            if(n%i == 0) result += i+" ";
        }
        String[] str = result.split(" ");
        int[] answer = Arrays.asList(str).stream().mapToInt(Integer::parseInt).toArray();
        return answer;
    }
}