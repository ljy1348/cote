import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String answer = "";
        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        for (int i = 6; i <= 100; i++) {
            arr[i] = arr[i-1]+arr[i-5];
        }
        int n = 0;
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            if (i == t-1) answer += arr[n];
            else answer += arr[n]+"\n";
        }
        System.out.println(answer);
    }
}