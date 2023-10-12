import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * packageName : backjoon.b2310
 * fileName : P1629
 * author : GGG
 * date : 2023-10-12
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-12         GGG          최초 생성
 */
public class Main {


        public static long powerMod(long a, long b, long c) {
            if (b == 1) {
                return a % c;
            }

            // Divide & Conquer
            long temp = powerMod(a, b / 2, c);
            temp = (temp * temp) % c;

            if (b % 2 == 0) {
                return temp;
            } else {
                return (temp * (a % c)) % c;
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            System.out.println(powerMod(a, b, c));
        }
}