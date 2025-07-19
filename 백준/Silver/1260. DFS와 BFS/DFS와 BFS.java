import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer> dfsResult = new ArrayList<>();
    static List<Integer> bfsResult = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        dfs(list, start);
        bfs(list, start);

        for (Integer index : dfsResult) {
            sb.append(index).append(" ");
        }
        System.out.println(sb.toString().trim());
        sb = new StringBuilder();
        for (Integer index : bfsResult) {
            sb.append(index).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static void dfs(List<List<Integer>> list, int start) {
        boolean[] visit = new boolean[list.size()+1];
        dfsFunc(list, visit, start);

    }

    static void dfsFunc(List<List<Integer>> list, boolean[] visit, int index) {

        if (visit[index]) {
            return;
        }
        visit[index] = true;
        dfsResult.add(index);
        List<Integer> lineList = list.get(index);
        Collections.sort(lineList);

        for (Integer next : lineList) {
            dfsFunc(list, visit, next);
        }


    }

    static void bfs(List<List<Integer>> list, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[list.size()+1];

        queue.add(start);

        while(!queue.isEmpty()) {
            int index = queue.poll();
            if (visit[index]) {
                continue;
            }

            visit[index] = true;
            bfsResult.add(index);

            List<Integer> lineList = list.get(index);
            Collections.sort(lineList);

            for (int now : lineList) {
                Collections.addAll(queue, now);
            }
        }





    }

}