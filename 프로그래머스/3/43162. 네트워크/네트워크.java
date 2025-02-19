import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        List<int[]>[] list = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList();
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                if (computers[i][j] == 1) {
                    list[i].add(new int[]{i,j});
                }
                
            }
        }
        boolean[] visit = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            answer++;
            List<int[]> newList = list[i];
            for (int j = 0; j < newList.size(); j++) {
                que.add(newList.get(j)[1]);    
            }
            visit[i] = true;
            while (!que.isEmpty()) {
                int idx = que.poll();
                if (visit[idx]) continue;
                visit[idx] = true;
                for (int j = 0; j < list[idx].size(); j++) {
                    que.add(list[idx].get(j)[1]);
                }
            }
        }
        
        return answer;
    }
}