import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;
        
        int[] coins = new int[n];
        StringBuilder sb = new StringBuilder();
        while (--n >= 0) {
            coins[n] = Integer.parseInt(br.readLine());
        }
        
        for (int coin : coins) {
            if (coin <= k) {
                answer += k/coin;
                k = k%coin;
            }
            if (k == 0) break;
        }

        sb.append(answer);
        System.out.println(sb);
        
    }
}