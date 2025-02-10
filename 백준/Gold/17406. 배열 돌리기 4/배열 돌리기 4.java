import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int staticResult = Integer.MAX_VALUE;

    public static void swap(int[][] calcArr, int idx, int i) {
        int[] temp = calcArr[idx];
        calcArr[idx] = calcArr[i];
        calcArr[i] = temp;
    }

    public static void dp(int[][] calcArr, int idx) {

        if (idx == calcArr.length-1) {
            int answer = calc(calcArr);
            staticResult = Math.min(staticResult, answer);
            return;
        }
            for (int i = idx; i < calcArr.length; i++) {
                swap(calcArr, idx, i);
                dp(calcArr, idx+1);
                swap(calcArr, idx, i);
            }



    }

    public static int calc(int[][] calcArr) {
        int[][] arr2 = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr2[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < calcArr.length; i++) {

            int r = calcArr[i][0];
            int c = calcArr[i][1];
            int s = calcArr[i][2];

            /**
             * 가장 왼쪽 윗 칸이 (r-s, c-s), 가장 오른쪽 아랫 칸이 (r+s, c+s)
             */
            int[] sArr = {r-s, c-s};
            int[] eArr = {r+s, c+s};
            int depth = ((r+s)-(r-s))/2;

            for (int j = 0; j < depth; j++) {
                int start = arr2[r-s+j-1][c-s+j-1];
                int y = r-s+j-1;
                int x = c-s+j-1;
                int turn = 0;
                while (true) {
                    if (turn == 0) {
                        arr2[y][x] = arr2[y+1][x];
                        y++;
                        if (y+1 >= r+s-j) {
                            turn++;
                            continue;
                        }

                    }
                    else if (turn == 1) {
                        arr2[y][x] = arr2[y][x+1];
                        x++;
                        if (x+1 >= c+s-j) {
                            turn++;
                            continue;
                        }
                    }
                    else if (turn == 2) {
                        arr2[y][x] = arr2[y-1][x];
                        y--;
                        if (y < r-s+j) {
                            turn++;
                            continue;
                        }
                    }
                    else if (turn == 3) {
                        arr2[y][x] = arr2[y][x-1];
                        x--;
                        if (x < c-s+j) {
                            turn++;
                            continue;
                        }
                    }
                    else if (turn == 4) {
                        arr2[r-s+j-1][c-s+j] = start;
                        break;
                    }
                }
            }



        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int min = 0;
            for (int j = 0; j < arr[0].length; j++) {
                min += arr2[i][j];
            }
            result = Math.min(result, min);
            if (result == 5) {
                int a = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] calcArr = new int[k][3];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            calcArr[i][0] = Integer.parseInt(st.nextToken());
            calcArr[i][1] = Integer.parseInt(st.nextToken());
            calcArr[i][2] = Integer.parseInt(st.nextToken());
        }

        dp(calcArr, 0);
        System.out.println(staticResult);


//        System.out.println(result);
    }
}