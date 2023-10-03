import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String str = sc.next();
        sc.close();
        int start = 0;
        int last = n*2+1;
        int result = 0;
        while(last <= m) {
            for (int i = start; i < last; i++) {
                if ((i-start)%2==0 && str.charAt(i) != 'I') break;
                if ((i-start)%2==1 && str.charAt(i) != 'O') break;
                if (i == last-1) result++;
            }
            start++;
            last++;
        }
        System.out.println(result);
    }
}