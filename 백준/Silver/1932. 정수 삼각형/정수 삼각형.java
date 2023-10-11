import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * packageName : backjoon.b2310
 * fileName : P1932
 * author : GGG
 * date : 2023-10-11
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-11         GGG          최초 생성
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i; j++) {
                arr[i-1][j] = Integer.parseInt(st.nextToken());
            }

        }
        for (int i = n-2; i >=0 ; i--) {
            for (int j = 0; j <= i ; j++) {
                arr[i][j] = Math.max(arr[i+1][j],arr[i+1][j+1]) + arr[i][j];
            }
        }
        System.out.println(arr[0][0]);
    }
}