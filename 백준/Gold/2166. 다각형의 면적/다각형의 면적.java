import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = a;
        long d = b;
        long sum = 0;
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());
            sum += (a*y - b*x);
            a = x;
            b = y;
        }
        sum += (d*a)-(c*b);
        double aa = Math.abs(sum / 2.0); // 2.0을 사용해 부동소수점 나눗셈을 수행
        aa = Math.round(aa * 10) / 10.0;  // 소수점 둘째 자리에서 반올림하여 첫째 자리까지 유지
        System.out.printf("%.1f\n", aa);

    }

}