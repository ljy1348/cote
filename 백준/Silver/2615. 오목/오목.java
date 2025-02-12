import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int[][] board = new int[19][19];
    static boolean[][][] visit = new boolean[19][19][4];
    static String xy = "";
    public static boolean calc(int dol, int i, int j) {

        int count = 0;

        //아래
        if (i != 18) {

            for (int k = i; k < 19; k++) {
                if (visit[k][j][0]) {
                    continue;
                }
                if (board[k][j] == dol) {
                    visit[k][j][0] = true;
                    count++;
                } else {
                    break;
                }
            }
        }
        if (count == 5) {
            int x = i+1;
            int y = j+1;
            xy = x+" "+y;
            return true;
        }
        count = 0;

        //오
        if (j != 18) {

            for (int k = j; k < 19; k++) {
                if (visit[i][k][1]) {
                    continue;
                }
                if (board[i][k] == dol) {
                    visit[i][k][1] = true;
                    count++;
                } else {
                    break;
                }
            }
        }
        if (count == 5) {
            int x = i+1;
            int y = j+1;
            xy = x+" "+y;
            return true;
        }
        count = 0;


        //왼아
        if (i != 18 && j != 0) {

            for (int k = 0; k < 19; k++) {
                if (i+k > 18 || j-k < 0) {
                    break;
                }
                if (visit[i+k][j-k][2]) {
                    continue;
                }
                if (board[i+k][j-k] == dol) {
                    visit[i+k][j-k][2] = true;
                    count++;
                } else {
                    break;
                }
            }
        }
        if (count == 5) {
            int x = i+5;
            int y = j+2-5;
            xy = x+" "+y;
            return true;
        }
        count = 0;

        //오아
        if (i != 18 && j != 18) {

            for (int k = 0; k < 19; k++) {
                if (i+k > 18 || j+k > 18) {
                    break;
                }
                if (visit[i+k][j+k][3]) {
                    continue;
                }
                if (board[i+k][j+k] == dol) {
                    visit[i+k][j+k][3] = true;
                    count++;
                } else {
                    break;
                }
            }
        }
        if (count == 5) {
            int x = i+1;
            int y = j+1;
            xy = x+" "+y;
            return true;
        }
        return false;

    }

    public static void main(String[] args) throws IOException {
        int n = 19;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int dol = board[i][j];
                if (dol == 0) {
                    continue;
                } else if (dol == 1) {
                    if (calc(dol, i, j)) {
                      result = dol;
                    };
                } else if (dol == 2) {
                    if (calc(dol, i, j)) {
                      result = dol;
                    };
                }
            }
            if (result > 0) {
                break;
            }
        }
        System.out.println(result);
        if (!"".equals(xy)) {
            System.out.println(xy);
        }

    }


}