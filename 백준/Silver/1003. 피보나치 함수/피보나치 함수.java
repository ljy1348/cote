import java.util.Scanner;

/**
 * packageName : backjoon
 * fileName : P1003
 * author : GGG
 * date : 2023-09-26
 * description : 피보나치 함수
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-09-26         GGG          최초 생성
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String answer = "";
        int[][] result = new int[41][2];
            for (int j = 0; j <= 40; j++) {
                if (j == 0) result[0][0]++;
                else if (j == 1) {
                    result[1][0] = 0;
                    result[1][1] = 1;
                } else {
                    result[j][0] = result[j-1][0]+result[j-2][0];
                    result[j][1] = result[j-1][1] + result[j-2][1];
                }
            }
            for (int i = 0; i < n; i++) {
                int m = sc.nextInt();
                if (i == n-1) answer += result[m][0] + " " + result[m][1];
                else answer += result[m][0] + " " + result[m][1]+"\n";
            }
        System.out.println(answer);
    }

}