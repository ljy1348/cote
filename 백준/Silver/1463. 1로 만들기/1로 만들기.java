import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n+1];

        for (int i = 2; i <= n; i++) {

            int res1 = Integer.MAX_VALUE;
            int res2 = Integer.MAX_VALUE;
            int res3 = Integer.MAX_VALUE;

            if (i%2 == 0) {
                res1 = arr[i/2];
            }

            if (i%3 == 0) {
                res2 = arr[i/3];
            }

            res3 = arr[i-1];

            arr[i] = Math.min(res1, Math.min(res2, res3)) + 1;

        }

        System.out.println(arr[n]);

    }
}