import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer sto = new StringTokenizer(br.readLine());
        StringTokenizer sto2 = new StringTokenizer(br.readLine());

        int[][] arr = new int[n][2];
        long result = 0;

        for (int i=0; i < n; i++) {
            int first =  Integer.parseInt(sto.nextToken());
            int plus = Integer.parseInt(sto2.nextToken());
            arr[i][0]= plus;
            arr[i][1]= first;
        }

        Arrays.sort(arr, (t1, t2) -> Integer.compare(t1[0], t2[0]));

        for (int i=0; i<n; i++) {
           result += arr[i][0]*i + arr[i][1];
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }

}