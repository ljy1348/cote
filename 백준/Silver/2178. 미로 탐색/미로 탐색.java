import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * packageName : backjoon
 * fileName : P2178
 * author : GGG
 * date : 2023-10-06
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-06         GGG          최초 생성
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][m+1];
        boolean[][] visit = new boolean[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j+1] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        Queue<int[]> que = new LinkedList<>();
        int[] start = {1,1};
        visit[1][1] = true;
        que.add(start);
        
        while (que.size() > 0) {
            int[] temp = que.poll();
            int x = temp[0];
            int y = temp[1];
            // 상
            if (x > 1) {
                if (arr[x-1][y] == 1 && visit[x-1][y] == false) {int[] temp1 = {x-1,y};
                    que.add(temp1); visit[x-1][y] = true;
                    arr[x-1][y] = arr[x][y]+1;} 
            }
            // 하
            if (x < n) {
                if (arr[x+1][y] == 1 && visit[x+1][y] == false) {int[] temp1 = {x+1,y};
                    que.add(temp1); visit[x+1][y] = true;
                    arr[x+1][y] = arr[x][y]+1;}
            }
            // 좌
            if (y > 1) {
                if (arr[x][y-1] == 1 && visit[x][y-1] == false) {int[] temp1 = {x,y-1};
                    que.add(temp1); visit[x][y-1] = true;
                    arr[x][y-1] = arr[x][y]+1;}
            }
            // 우
            if (y < m) {
                if (arr[x][y+1] == 1 && visit[x][y+1] == false) {int[] temp1 = {x,y+1};
                    que.add(temp1); visit[x][y+1] = true;
                    arr[x][y+1] = arr[x][y]+1;}
            }
        }
        System.out.println(arr[n][m]);
        
    }
}