import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        int idx = 0;
        while (idx < progresses.length) {

            for (int i = 0; i < progresses.length; i++) {
                int temp = progresses[i];
                int temp2 = speeds[i];
                temp += temp2;
                progresses[i] = temp;
            }

            int temp = 0;
            for (int i = idx; i < progresses.length; i++) {
                if (progresses[i] >= 100) {
                    idx++;
                    temp++;
                } else {
                    break;
                }
            }
            if (temp > 0) {
                result.add(temp);
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] =result.get(i);
        }
        return answer;
    }
}