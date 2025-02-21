import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] result = new int[2];
    static int[][] board;

    public static void func(int x, int y, int n) {
        if (n == 0) return;
        int newN = n/2;
        int[][] temp = {{x,y},{x,y+newN},{x+newN,y},{x+newN,y+newN}};

        int blue = 0;
        int white = 0;
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (board[i][j] == 1) blue++;
                else white++;
            }
        }
        if (blue == 0) {
            result[0]++;
            return;
        }
        else if (white == 0) {
            result[1]++;
            return;
        }
        for (int i = 0; i < temp.length; i++) {
            int a = temp[i][0];
            int b = temp[i][1];

            func(temp[i][0], temp[i][1], newN);
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        int blue = 0;
        int white = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (now == 1) blue++;
                else white++;
                board[i][j]=now;
            }
        }

        if (blue == 0) {
            System.out.println(1);
            System.out.println(0);
        } else if (white == 0) {
            System.out.println(0);
            System.out.println(1);
        } else {
            func(0,0,n);
            System.out.println(result[0]);
            System.out.println(result[1]);
        }





    }
}