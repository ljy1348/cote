import java.util.Scanner;

/**
 * packageName : backjoon
 * fileName : P2839
 * author : GGG
 * date : 2023-09-18
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-09-18         GGG          최초 생성
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int division5 = (int)Math.floor(n/5);
        int division3 = (int)Math.floor(n/3);
        int result = -1;
        int sum = 0;
        int count = 0;
        for (int i = 0; i <= division3; i++) {
            for (int j = 0; j <= division5; j++) {
                sum = 3*i + 5*j;
                if (sum == n && count == 0) {
                    result = i+j;
//                    System.out.println(i+","+j);
                    count++;
                }
                }
        }


        System.out.println(result);
    }

}