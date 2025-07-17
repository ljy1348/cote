import java.util.*;
import java.io.*;

public class Main {

    static long[] arr = new long[41];
    static long zero = 0L;
    static long one = 0L;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= 40; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        
        while (--n >= 0) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                sb.append(1).append(" ").append(0).append("\n");
            }  else  {
                sb.append(arr[input-1]).append(" ").append(arr[input]).append("\n");    
            }
            
        }
        
        System.out.println(sb);
        
    }
}