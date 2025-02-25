import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] >= s) {
                System.out.println(1);
                return;
            }
        }

        int start = 0;
        int end = 1;
        long sum = arr[0];
        long count = Integer.MAX_VALUE;
        while (end < n && start < n-1) {
            sum += arr[end];
//            System.out.println(sum);
            while (sum >= s && start < end) {
                count = Math.min(count, end - start);
                sum -= arr[start];
                start++;
            }
            end++;

        }
        if (count == Integer.MAX_VALUE) {
            count = -1;
        }
        System.out.println(count+1);

    }
}