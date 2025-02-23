import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = n-1;
        int sum = Integer.MIN_VALUE;
        if (arr[n-1] < 0) {
            System.out.println(arr[n-2]+" "+ arr[n-1]);
            return;
        }

        int result1 = 0;
        int result2 = 0;
        int min = Integer.MAX_VALUE;
        while (start < end) {
//            System.out.println(start + " " + end);
            if (arr[start] <= 0 && arr[end] <= 0) {
                int temp = Math.abs(arr[end-1] + arr[end]);
                if (temp < min) {
                    result1 = end-1;
                    result2 = end;
                }
                break;
            }
            if (arr[start] >= 0 && arr[end] >= 0) {
                int temp = Math.abs(arr[start] + arr[start+1]);
                if (temp < min) {
                    result1 = start;
                    result2 = start+1;
                }
                break;
            }

            int nextSum = arr[start] + arr[end];
            if (Math.abs(nextSum) <= min) {
                min = Math.abs(nextSum);
                result1 = start;
                result2 = end;
            }
            if (nextSum == 0) {
                break;
            }
            if (nextSum < 0) {
                start++;
            } else if (nextSum > 0) {
                end--;
            }
            sum = nextSum;

        }
        System.out.println(arr[result1]+" " + arr[result2]);
    }

}