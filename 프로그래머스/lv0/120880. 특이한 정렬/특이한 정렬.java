import java.util.Arrays;
class Solution {
    public int[] solution(int[] numlist, int n) {
        
        Arrays.sort(numlist);
        for (int j = 0; j < numlist.length; j++) {
        for (int i = 0; i < numlist.length-1; i++) {
            int a = Math.abs(numlist[i] - n);
            int b = Math.abs(numlist[i+1]-n);
            if (a > b) {
                int temp = numlist[i+1];
                numlist[i+1] = numlist[i];
                numlist[i] = temp;
            } else if (a == b && numlist[i] < numlist[i+1]) {
                int temp = numlist[i+1];
                numlist[i+1] = numlist[i];
                numlist[i] = temp;
            }
        }
        }
        
        
        
        
        int[] answer = numlist;
        return answer;
    }
}