import java.util.Arrays;
class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] dice = new int[7];
        Arrays.fill(dice,0);
        dice[a]++;
        dice[b]++;
        dice[c]++;
        dice[d]++;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 4) {
                answer = i*1111;
                break;
            }
            else if (dice[i] == 3) {
                for (int j = 0; j < dice.length; j++) {
                    if (dice[j] == 1) answer = (int)Math.pow(10*i+j,2);
                }
                break;
            }
            else if (dice[i] == 2) {
                for (int j = 0; j < dice.length; j++) {
                    int[] p = new int[2];
                    if (dice[j] == 2) {
                        if (i != j) answer = (i+j)*(Math.abs(i-j));

                    }
                    if (dice[j] == 1) {
                        for (int m = 1; m < dice.length; m++) {
                            if (j != m && dice[m] == 1) p[1] = m;
                        }
                        p[0] = j;
                        answer = p[0] * p[1];
                    }
                }
                break;
            }
        }
        if (answer == 0) {
            int min = Math.min(a,b);
            min = Math.min(min,c);
            min = Math.min(min,d);
            answer = min;
        }
        
        return answer;
    }
}