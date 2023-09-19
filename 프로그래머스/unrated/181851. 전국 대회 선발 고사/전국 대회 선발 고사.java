import java.util.Arrays;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
       int answer = 0;
        int count = 0;
        for (int i = 1; i <= rank.length; i++) {
          for (int j = 1; j <= rank.length; j++) {
              if (rank[j-1] == i && attendance[j-1] == true) {
                  if (count == 0) answer += (j-1)*10000;
                  if (count == 1) answer += (j-1)*100;
                  if (count == 2) answer += (j-1);
                  count++;
              }
          }
            if (count == 3) break;
        }

        return answer;
    }
}