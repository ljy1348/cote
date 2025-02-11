import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int n = Integer.parseInt(sc.nextLine());
//            int n = sc;
            long answer = 1;
            if (n == 0) {
                System.out.println(0);
                return;
            }
            for (int i = 1; i <= n; i++) {
                int num = i;
                while (num % 10 == 0) {
                    num = num / 10;
                }

                answer *= i;

                while (answer % 10 == 0) {
                    answer = answer / 10;
                }

                answer %= 10000000;
            }
//            System.out.println(answer);
            answer %= 10;
//            System.out.println(sc + " : " + answer + " , " + sol);

        System.out.println(answer);
        }


}