import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[][] arr = new int[n][2];
        int[] num = new int[n];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
            num[i] = arr[i][0];
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i][0] != arr[i-1][0]) {
                count++;
                result[arr[i][1]] = count;
            }
            else {
                result[arr[i][1]] = count;
            }
            }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb);


    }
}