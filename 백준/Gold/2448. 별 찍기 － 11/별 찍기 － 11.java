import java.util.Arrays;
import java.util.Scanner;

public class Main {
        static String[][] arr;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxY = n;
        int maxX = (n/3)*5 + (n/3)-1;

        arr = new String[maxY][maxX];
        for (int i = 0; i <n ; i++) {
        Arrays.fill(arr[i], " ");
        }


        solution(n, n-1, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < maxX; j++) {
                sb.append(arr[i][j]);
            }
            if (i < n-1) sb.append("\n");
        }
        System.out.println(sb);
//        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
//        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
//        System.out.println("시간차이(m) : "+secDiffTime);
//        Runtime.getRuntime().gc();
//        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//        System.out.print(usedMemory + " bytes");
    }

    static void solution(int count, int x, int y) {
        if (count == 3) {
            arr[y][x] = "*";
            arr[y+1][x-1] = "*";
            arr[y+1][x+1] = "*";
            arr[y+2][x-2] = "*";
            arr[y+2][x-1] = "*";
            arr[y+2][x] = "*";
            arr[y+2][x+1] = "*";
            arr[y+2][x+2] = "*";
            return;
        }

        int count2 = count/2;
        solution(count2,x,y);
        solution(count2,x - count2,y + count2);
        solution(count2,x + count2,y + count2);
    }
}