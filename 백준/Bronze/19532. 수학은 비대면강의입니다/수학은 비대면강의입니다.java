import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] token = new int[7];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int x = 0;
        int y = 0;
        for (int i = 1; i < 7; i++) {
            token[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                if (token[1]*i + token[2]*j == token[3] && token[4]*i + token[5]*j == token[6]) {
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(x+" "+y);

    }
}