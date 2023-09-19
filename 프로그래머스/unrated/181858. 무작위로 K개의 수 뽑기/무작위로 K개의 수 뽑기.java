import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        int count = 1;
        answer[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            boolean bool = false;
            for (int j = 0; j < count; j++) {
                if (answer[j] == arr[i]){bool = true; break;}
            }
            if (bool == false) {
                answer[count] = arr[i]; 
                count++;
                if (count == k) break;
            }
        }
        return answer;
    }
}