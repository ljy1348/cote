import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][] tomato;
        tomato = new int[n * h][m];
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visit = new boolean[n*h][m];
        for (int i = 0; i < n*h; i++) {
        st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                tomato[i][j] = temp;
                if (temp == 1) {int[] arr = {i,j};
                que.add(arr);
                visit[i][j] = true;}
            }
        }
        int day = 2;
        while (true) {
            for (int i = que.size(); i > 0 ; i--) {
                int[] temp = que.poll();
                int y = temp[0];
                int x = temp[1];
                // 윗상자
                if (y >= n) {
                    if (visit[y-n][x] == false && tomato[y-n][x] == 0) {tomato[y-n][x] = day; visit[y-n][x] = true;
                    int[] xy = {y-n,x}; que.add(xy);}
                }
                // 아랫상자
                if (y+n < n*h ) {
                    if (visit[y+n][x] == false && tomato[y+n][x] == 0) {tomato[y+n][x] = day; visit[y+n][x] = true;
                        int[] xy = {y+n,x}; que.add(xy);}
                }
                // 상
                if (y > 0 && y%n >0) {
                    if (visit[y-1][x] == false && tomato[y-1][x] == 0) {tomato[y-1][x] = day; visit[y-1][x] = true;
                        int[] xy = {y-1,x}; que.add(xy);}
                }
                // 하
                if (y < n*h && y%n < n-1) {
                    if (visit[y+1][x] == false && tomato[y+1][x] == 0) {tomato[y+1][x] = day; visit[y+1][x] = true;
                        int[] xy = {y+1,x}; que.add(xy);}
                }
                // 좌
                if (x < m-1) {
                    if (visit[y][x+1] == false && tomato[y][x+1] == 0) {tomato[y][x+1] = day; visit[y][x+1] = true;
                        int[] xy = {y,x+1}; que.add(xy);}
                }
                if (x > 0) {
                    if (visit[y][x-1] == false && tomato[y][x-1] == 0) {tomato[y][x-1] = day; visit[y][x-1] = true;
                        int[] xy = {y,x-1}; que.add(xy);}
                }
            }
            if (que.size()==0) break;
            day++;
        }
        for (int i = 0; i < n*h; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] == false && tomato[i][j] == 0) day = 1;
            }
        }
        System.out.println(day-2);
        }
    }