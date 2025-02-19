import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> que = new LinkedList();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < priorities.length; i++) {
            int[] temp = {priorities[i], i};
            que.add(temp);
            maxHeap.add(priorities[i]);
        }
        while (que.size() > 0) {
            int[] now = que.poll();
            int maxPriority = maxHeap.peek();
            if (now[0] >= maxPriority) {
                answer++;
                if (now[1] == location) break;
                maxHeap.poll();
            } else {
                que.add(now);
            }
        }
        
        return answer;
    }
}