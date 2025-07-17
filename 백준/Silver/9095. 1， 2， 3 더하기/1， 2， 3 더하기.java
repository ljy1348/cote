import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        /**
        dp[1] = 1 (1)
        dp[2] = 2 (1+1, 2)
        dp[3] = 4 (1+1+1, 1+2, 2+1, 3)
        dp[4] = 7 (1+1+1+1, 1+1+2, 1+3, 2+2, 3+1, 2+1+1, 1+2+1)
        점화식 = dp[n] = dp[n-1] + dp[n-2] + dp[n-3];
        **/
        
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        
        StringBuilder sb = new StringBuilder();

        
        int numTest = Integer.parseInt(br.readLine());
        
        while(numTest-- > 0) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb);
        
        
    }


}