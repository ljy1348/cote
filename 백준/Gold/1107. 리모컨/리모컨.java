import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * 5457
         * 3
         * 6 7 8
         * 답 : 6
         * 500000
         * 8
         * 0 2 3 4 6 7 8 9
         * 답 : 11117
         * */
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String numStr = br.readLine();
            int n = Integer.parseInt(numStr);
            int m = Integer.parseInt(br.readLine());
            int result = 0;
            int[] remote = new int[10];
            int max = 0;
            int min = 999999;
            if (m > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < m; i++) {
                    int temp = Integer.parseInt(st.nextToken());
                    remote[temp] = 1;
                }
            }
            for (int i = 0; i < remote.length; i++) {
                if (remote[i] == 0) {
                    max = Math.max(max, i);
                    min = Math.min(min, i);
                }
            }
            if (max != 0) {
                max = Integer.parseInt((String.valueOf(max)).repeat(numStr.length() + 2));

                formax:
                for (int i = n; i < max; i++) {
                    String str = String.valueOf(i);
                    for (int j = 0; j < remote.length; j++) {
                        if (str.contains(String.valueOf(j)) && remote[j] == 1) {
                            continue formax;
                        }
                    }
                    max = (i - n) + str.length();
                    break;
                }
            } else max = 99999999;
            if (n >= min) {
                formin:
                for (int i = n; i >= min; i--) {
                    String str = String.valueOf(i);
                    for (int j = 0; j < remote.length; j++) {
                        if (str.contains(String.valueOf(j)) && remote[j] == 1) {
                            continue formin;
                        }
                    }
                    min = (n - i) + str.length();
                    break;
                }
            } else min = 99999999;
            result = Math.min(max, min);
            result = Math.min(result, Math.abs(n - 100));
            System.out.println(result);
    }
}