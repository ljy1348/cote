import java.util.Arrays;
class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int [] cal = new int[201];
        Arrays.fill(cal,0);
        for (int i = 0; i<lines.length; i++) {
            for (int j = lines[i][0]; j <= lines[i][1]; j++) {
                if (j == lines[i][0]) continue;
                cal[j+100] += 1;
            }
        }
        int count = 0;
        for (int i = 0; i < cal.length; i++) {
            if (cal[i]>1) count++;
        }

        System.out.println(count);
        answer = count;
        return answer;
    }
}