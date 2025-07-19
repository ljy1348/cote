import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int testCase = Integer.parseInt(br.readLine());
        
        while (testCase-- > 0) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            boolean[][] arr = new boolean[n][m];
            
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int m1 = Integer.parseInt(st.nextToken());
                int n1 = Integer.parseInt(st.nextToken());
                arr[n1][m1] = true;
            }
            
            int count = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (func(arr, i, j)) {
                        count++;
                    }
                }
            }
            
            sb.append(count).append("\n");
            
        }
        System.out.println(sb);
    }
    
    static boolean func(boolean[][] arr,int n,int m) {
        if (!arr[n][m]) {
            return false;
        }
        
        arr[n][m] = false;
        
        if (n > 0) {
            func(arr, n-1 ,m);
        }
        if (n < arr.length-1)  {
            func(arr, n+1 ,m);
        }
        if (m > 0) {
            func(arr, n ,m-1);
        }
        if (m < arr[0].length-1)  {
            func(arr, n ,m+1);
        }
        return true;
    }
    
}