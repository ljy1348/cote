import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> running = new LinkedList<>();
        Queue<Integer> delay = new LinkedList<>();
        
        for (int i = 0; i < truck_weights.length; i++) {
            delay.add(truck_weights[i]);
        }
        int weightSum = 0;
        while (delay.size() > 0) {
            answer += 1;
            if (running.size() == bridge_length) {
                int now = running.poll();
                weightSum -= now;
            }
            if (delay.peek() + weightSum <= weight) {
                int now = delay.poll();
                running.add(now);
                weightSum += now;
            } else {
                running.add(0);
            }
            
        }
        if (running.size() > 0) {
            answer += bridge_length;
        }
        return answer;
    }
}