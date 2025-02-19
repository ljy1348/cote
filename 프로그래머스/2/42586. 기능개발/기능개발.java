import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] work = new int[progresses.length];
        List<Integer> list = new ArrayList();
        
        for (int i = 0; i<progresses.length; i++) {
            work[i] = (int) Math.ceil((100 - progresses[i])/((double) speeds[i]));
        }
        
        int workMax = work[0];
        int count = 1;
        for (int i = 1; i < work.length; i++) {
            if (work[i] <= workMax) {
                count++;
            } else {
                list.add(count);
                workMax = work[i];
                count = 1;
            }
        }
        list.add(count);
        int[] answer = new int[list.size()];
        for (int i = 0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}