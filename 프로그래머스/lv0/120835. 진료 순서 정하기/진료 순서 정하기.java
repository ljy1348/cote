import java.util.Arrays;
class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] sortArr = new int[emergency.length];
        for (int i = 0; i < emergency.length; i++) {
            sortArr[i] = emergency[i];
        }
        Arrays.sort(sortArr);
        for (int i = 0; i < emergency.length; i++) {
            for (int j = 0; j < emergency.length; j++) {
              if (emergency[j] == sortArr[sortArr.length-1-i]) {
                  answer[j] = i+1;
              }
            }
        }
        
        
        return answer;
    }
}