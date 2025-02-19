import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static boolean[][] visit;
    static int[][] board;
    static Queue<int[]> que;
    static List<Integer> list;
    public static void bfs(int[] xy) {
        if (visit[xy[0]][xy[1]]) return;
        int[][] deep = {{1,0},{-1,0},{0,1},{0,-1}};

        int now = board[xy[0]][xy[1]];
        visit[xy[0]][xy[1]] = true;
        que = new LinkedList<>();
        if (now > 0) {
            que.add(xy);
        } else {
            return;
        }
        int count = 0;
        while (!que.isEmpty()) {
            count++;
            int[] xy2 = que.poll();

            for (int i = 0; i < deep.length; i++) {
                int x = xy2[0] + deep[i][0];
                int y = xy2[1] + deep[i][1];

                if (x >= 0 && x <= n - 1 && y >= 0 && y <= n - 1 && !visit[x][y]) {
                    int next = board[x][y];
                    visit[x][y] = true;
                    if (next == 1) {
                        que.add(new int[]{x, y});
                    }
                }
            }
        }
        list.add(count);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visit = new boolean[n][n];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        int[] xy = {0,0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bfs(new int[]{i,j});

            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}