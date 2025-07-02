import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int index = 0;
        List<Integer> resultList = new ArrayList<>();
        int workCount = progresses.length;
        
        while(index < workCount) {
            int compDay = (int) Math.ceil((100.0 - progresses[index]) / speeds[index]);
            int dayCompleteCount = 0;
            boolean is_linked = true;
            for (int i = index; i < workCount; i++) {
                int now = progresses[i] + (compDay * speeds[i]);
                if (is_linked && now >= 100) {
                    progresses[i] = now;
                    dayCompleteCount++;
                    index++;
                } else {
                    progresses[i] = now;
                    is_linked = false;
                }
            }
            
            resultList.add(dayCompleteCount);
            
        }      
        
        int[] result = new int[resultList.size()];
        
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}