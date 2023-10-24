import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] time = new int[n + 1];
            int[] inDegree = new int[n + 1];
            int[] result = new int[n + 1];
            List<Integer>[] graph = new ArrayList[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                time[j] = Integer.parseInt(st.nextToken());
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);
                inDegree[y]++;
            }

            int w = Integer.parseInt(br.readLine());

            // 위상 정렬 (Topological Sort)
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 1; j <= n; j++) {
                if (inDegree[j] == 0) {
                    queue.add(j);
                    result[j] = time[j];
                }
            }

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int next : graph[curr]) {
                    result[next] = Math.max(result[next], result[curr] + time[next]);
                    if (--inDegree[next] == 0) {
                        queue.add(next);
                    }
                }
            }

            System.out.println(result[w]);
        }
    }
}