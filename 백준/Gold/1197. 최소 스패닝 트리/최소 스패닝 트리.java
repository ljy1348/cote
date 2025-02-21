import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] union;

    public static int find(int x) {
        if (union[x] != x) {
            union[x] = find(union[x]);
        }
        return union[x];
    }

    public static boolean union(int x, int y) {
        int i = find(x);
        int j = find(y);
        if (i == j) {
            return true;
        } else {
            union[j] = i;
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int[] row = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            arr[i] = row;
        }

        union = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            union[i] = i;
        }

        Arrays.sort(arr, (a,b)->{return Integer.compare(a[2],b[2]);});
        int count = 0;
        int result = 0;
        for (int[] arr1 : arr) {
            int start = arr1[0];
            int end = arr1[1];
            if (union(start, end)) continue;
            count++;
            result += arr1[2];
            if (count == n-1) break;
        }

        System.out.println(result);

    }
}