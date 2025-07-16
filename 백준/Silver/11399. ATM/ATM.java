import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int peoples = Integer.parseInt(br.readLine());
        
        
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[peoples];
        int[] times = new int[peoples];
        
        for (int i = 0; i < peoples; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        times[0] = arr[0];
        long answer = times[0];
        for (int i = 1; i < peoples; i++) {
            times[i] = arr[i] + times[i-1];
            answer += times[i];
        }
        System.out.println(answer);
    }


}