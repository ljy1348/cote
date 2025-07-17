import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        long[] dp = new long[101];
        
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        
        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i-1] + dp[i-5];
        }
        

        int numTest = Integer.parseInt(br.readLine());

        while (numTest-- > 0) {
            int input = Integer.parseInt(br.readLine());
            sb.append(dp[input]).append("\n");
        }

        System.out.println(sb);


    }


}