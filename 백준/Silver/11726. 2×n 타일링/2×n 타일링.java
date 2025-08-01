import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[1001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= 1000;  i++) {
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }



        System.out.println(dp[n]);


    }


}