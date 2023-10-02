import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * packageName : backjoon
 * fileName : P14940
 * author : GGG
 * date : 2023-10-02
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-02         GGG          최초 생성
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int y = 0;
        int x = 0;
        boolean[][] visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if (num == 2) {
                    y = i;
                    x = j;
                }
            }
        }
        arr[y][x] = 0;
        Queue<int[]> que = new LinkedList<>();
        while (true) {
            // 상
            if (y > 0) {
                if (arr[y-1][x] == 1 && visit[y-1][x] == false) {
                    int[] temp = {y-1,x};
                    arr[y-1][x] = arr[y][x]+1;
                    visit[y-1][x] = true;
                    que.add(temp);
                }
            }
            // 하
            if (y < n-1) {
                if (arr[y+1][x] == 1 && visit[y+1][x] == false) {
                    int[] temp = {y+1,x};
                    arr[y+1][x] = arr[y][x]+1;
                    visit[y+1][x] = true;
                    que.add(temp);
                }
            }
            // 좌
            if (x < m-1) {
                if (arr[y][x+1] == 1 && visit[y][x+1] == false) {
                    int[] temp = {y,x+1};
                    arr[y][x+1] = arr[y][x]+1;
                    visit[y][x+1] = true;
                    que.add(temp);
                }
            }
            // 우
            if (x > 0) {
                if (arr[y][x-1] == 1 && visit[y][x-1] == false) {
                    int[] temp = {y,x-1};
                    arr[y][x-1] = arr[y][x]+1;
                    visit[y][x-1] = true;
                    que.add(temp);
                }
            }
            if (que.size() == 0) break;
            int[] 좌표 = que.poll();
            y = 좌표[0];
            x = 좌표[1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && visit[i][j] == false) arr[i][j] = -1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0)sb.append(arr[i][j]);
                else {
                    sb.append(" ");
                    sb.append(arr[i][j]);
                }
            }
            if (i != n - 1) sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}