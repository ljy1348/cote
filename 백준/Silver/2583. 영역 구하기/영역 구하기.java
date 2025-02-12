import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Stack<int[]> area = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            y1 = m - y1;
            y2 = m - y2;

            for (int j = y1-1; j >= y2; j--) {
                for (int s = x1; s < x2; s++) {
                    board[j][s] = 1;
                }
            }


        }
         for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    int now = board[j][l];
                    if (now == 0 && !visited[j][l]) {
                        area.add(new int[]{j,l});
                        int count = 0;
                        while (!area.isEmpty()) {
                            int[] xy = area.pop();
                            if (visited[xy[0]][xy[1]]) {
                                continue;
                            }
                            count++;
                            visited[xy[0]][xy[1]] = true;
                            //상
                            if (xy[0]-1 >= 0 && board[xy[0]-1][xy[1]] == 0) {
                                area.add(new int[]{xy[0]-1, xy[1]});
                            }
                            //하
                            if (xy[0]+1 < m && board[xy[0]+1][xy[1]] == 0) {
                                area.add(new int[]{xy[0]+1, xy[1]});
                            }
                            //좌
                            if (xy[1]-1 >= 0 && board[xy[0]][xy[1]-1] == 0) {
                                area.add(new int[]{xy[0], xy[1]-1});
                            }
                            //우
                            if (xy[1]+1 < n && board[xy[0]][xy[1]+1] == 0) {
                                area.add(new int[]{xy[0], xy[1]+1});
                            }

                        }
                        result.add(count);
                    }

                }

            }

         Collections.sort(result);
        System.out.println(result.size());
        String str = "";
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) {
                str += " ";
            }
            str += result.get(i);
        }
        System.out.println(str);
    }
}