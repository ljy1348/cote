import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        Queue<int[]> que = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            que.clear();
            int[] now = {a, b, 0};
            int[] target = {c, d};
            if (a == c && b == d) {
                list.add(0);
                continue;
            }
            boolean[][] board = new boolean[n][n];

            que.add(now);
            while (!que.isEmpty()) {
                now = que.poll();
                try {
                    if (board[now[0]][now[1]]) {
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println(now[0] + " " + now[1]);
                    System.out.println(target[0] + " " + target[1]);
                }
                board[now[0]][now[1]] = true;
                // 1시,2시, 4시, 5시, 7시, 8시, 10시, 11시
                a = now[0] - 2;
                b = now[1] + 1;
                if (a == target[0] && b == target[1]) {
                    list.add(now[2]+1);
                    break;
                }
                if (a >= 0 && b < n) {
                    int[] next = {a, b, now[2]+1};
                    que.add(next);
                }
                a = now[0]-1;
                b = now[1]+2;
                if (a == target[0] && b == target[1]) {
                    list.add(now[2]+1);
                    break;
                }
                if (a >= 0 && b < n) {
                    int[] next = {a, b, now[2]+1};
                    que.add(next);
                }
                a = now[0]+1;
                b = now[1]+2;
                if (a == target[0] && b == target[1]) {
                    list.add(now[2]+1);
                    break;
                }
                if (a < n && b < n) {
                    int[] next = {a, b, now[2]+1};
                    que.add(next);
                }
                a = now[0]+2;
                b = now[1]+1;
                if (a == target[0] && b == target[1]) {
                    list.add(now[2]+1);
                    break;
                }
                if (a < n && b < n) {
                    int[] next = {a, b, now[2]+1};
                    que.add(next);
                }

                a = now[0]+1;
                b = now[1]-2;
                if (a == target[0] && b == target[1]) {
                    list.add(now[2]+1);
                    break;
                }
                if (a < n && b >= 0) {
                    int[] next = {a, b, now[2]+1};
                    que.add(next);
                }
                a = now[0]+2;
                b = now[1]-1;
                if (a == target[0] && b == target[1]) {
                    list.add(now[2]+1);
                    break;
                }
                if (a < n && b >= 0) {
                    int[] next = {a, b, now[2]+1};
                    que.add(next);
                }
                a = now[0]-2;
                b = now[1]-1;
                if (a == target[0] && b == target[1]) {
                    list.add(now[2]+1);
                    break;
                }
                if (a >= 0 && b >= 0) {
                    int[] next = {a, b, now[2]+1};
                    que.add(next);
                }
                a = now[0]-1;
                b = now[1]-2;
                if (a == target[0] && b == target[1]) {
                    list.add(now[2]+1);
                    break;
                }
                if (a >= 0 && b >= 0) {
                    int[] next = {a, b, now[2]+1};
                    que.add(next);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}