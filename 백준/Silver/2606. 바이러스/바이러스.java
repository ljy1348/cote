import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }
        int i = 1;
        Queue<Integer> que = new LinkedList<>();
        boolean[] visit = new boolean[n+1];
        visit[i] = true;
        while(true) {
            int count = list[i].size();
            for (int j = 0; j < count; j++) {
                int temp = list[i].get(j);
                if(visit[temp] == true) continue;
                else {
                    visit[temp] = true;
                    que.add(temp);
                }
            }
            if (que.size() == 0) break;
            i = que.poll();
        }
        int result = 0;
        for (int j = 2; j <= n; j++) {
            if (visit[j] == true) result++;
        }
        System.out.println(result);
    }
}