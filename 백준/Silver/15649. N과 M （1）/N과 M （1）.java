import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;

    public static void func1(int idx, int start, String s) {
        s += ""+start;
        if (s.length() >= m) {
            for (int i = 0; i < s.length(); i++) {
                System.out.print(s.charAt(i));
                if (i < s.length() -1)System.out.print(" ");
            }
            System.out.println("");
            return;
        }
        for (int i = 1; i <= n; i++) {
            boolean flag = false;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == i + '0') {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            func1(idx+1, i, s);
        }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n  = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            func1(0, i, "");
        }


    }


}