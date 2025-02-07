import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int start = 0;
        int min = Math.min(n,m);
        int max = min/2;
        List<Integer>[] list = new ArrayList[max];
        for (int i = 0; i < max; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < max; i++) {
            for (int j = i; j < m-i; j++) {
                list[i].add(arr[i][j]);
            }
            for (int j = i+1; j < n-i; j++) {
                list[i].add(arr[j][m-i-1]);
            }
            for (int j = m-i-2; j >= i; j--) {
                list[i].add(arr[n-i-1][j]);
            }
            for (int j = n-i-2; j > i; j--) {
                list[i].add(arr[j][i]);
            }
        }

        for (int i = 0; i < max; i++) {
            int idx = r;
            while (idx >= list[i].size()) {
                    idx = idx - list[i].size();
                }
            for (int j = i; j < m-i; j++) {
                arr[i][j] = list[i].get(idx);
                idx++;
                if (idx >= list[i].size()) {
                    idx = 0;
                }
            }
            for (int j = i+1; j < n-i; j++) {
                arr[j][m-i-1] = list[i].get(idx);
                idx++;
                if (idx >= list[i].size()) {
                    idx = 0;
                }
            }
            for (int j = m-i-2; j >= i; j--) {
                arr[n-i-1][j] = list[i].get(idx);
                idx++;
                if (idx >= list[i].size()) {
                    idx = 0;
                }
            }
            for (int j = n-i-2; j > i; j--) {
                arr[j][i] = list[i].get(idx);
                idx++;
                if (idx >= list[i].size()) {
                    idx = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]);
                if (j < m-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}