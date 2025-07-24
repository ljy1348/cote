import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());

        visit = new boolean[nodeNum+1];

        list = new ArrayList<>();

        while (nodeNum-- >= 0) {
            list.add(new ArrayList<>());
        }

        while (edgeNum-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        int result = 0;

        for (int i = 1; i < visit.length; i++) {
            if (dfs(i)) {
                result++;
            }
        }

        System.out.println(result);

    }

    static boolean dfs(int node) {
        if (visit[node]) {
            return false;
        }

        visit[node] = true;

        for (int next : list.get(node)) {
            dfs(next);
        }
        return true;
    }
    
}