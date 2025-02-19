import java.util.*;
class Solution {
    
    public int solution(int[][] maps) {
        int answer = -1;

        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> que = new LinkedList<>();
        
        boolean[][] visit = new boolean[n][m];
        
        que.add(new int[]{0,0,0});
        
        int[][] dp = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while (!que.isEmpty()) {
            int[] now = que.poll();
            if (visit[now[0]][now[1]]) continue;
            visit[now[0]][now[1]] = true;
            
            if (now[0] == n-1 && now[1] == m-1) {
                answer = now[2]+1;
                break;
            }
            for (int i = 0; i < dp.length; i++) {
                int x = now[0] + dp[i][0];
                int y = now[1] + dp[i][1];
                int count = now[2];
                if (x >= 0 && x < n && y >= 0 && y < m && !visit[x][y]) {
                    int next = maps[x][y];
                    if (next == 1) {
                        que.add(new int[]{x,y,count+1});
                    }
                }
            }
            
        }
        
        
        
        return answer;
    }
}