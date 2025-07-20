import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {

        List<Integer> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(n, arr, 0, 0);

        System.out.println(white);
        System.out.println(blue);
        br.close();
    }

    public static void func(int n, int[][] arr, int y, int x) {

        boolean haveZero = false;
        boolean haveOne = false;

        for (int i = y; i < n+y; i++){
            for (int j = x; j < n+x; j++) {
                if (arr[i][j] == 0) {
                    haveZero = true;
                } else {
                    haveOne = true;
                }
            }
        }

        if (!haveZero && haveOne) {
            blue++;
            return;
        }
        if (haveZero && !haveOne) {
            white++;
            return;
        }

        int nextN = n/2;

        func(n/2, arr, y, x);
        func(n/2, arr, y+nextN, x);
        func(n/2, arr, y+nextN, x+nextN);
        func(n/2, arr, y, x+nextN);


    }
}