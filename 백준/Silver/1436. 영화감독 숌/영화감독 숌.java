import java.util.Scanner;

/**
 * packageName : backjoon
 * fileName : P1436
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
        int count = 0;
        int i = 666;
        while (count < n) {
            String num = String.valueOf(i);
//            System.out.println(num);
            if (num.contains("666")) count++;
            i++;
        }
        System.out.println(i-1);
    }

}