import java.io.*;
import java.util.*;

public class Main {
    static int count;
    public static int dfs(int node, int parent, int[] treeSize, List<Integer>[] list) {
        treeSize[node] = 1;
        for (int i : list[node]) {
            if (i == parent) {
                continue;
            }
            treeSize[node] += dfs(i, node, treeSize, list);
        }
        return treeSize[node];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        List<Integer>[] list = new ArrayList[n+1];

        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        int[]  sizes = new int[n+1];
        count = dfs(r,0,sizes, list);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < q; i++) {
            int test = Integer.parseInt(br.readLine());
            bw.write(sizes[test] + "\n");
        }
        bw.flush();


    }
}