import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
//        long beforeTime = System.currentTimeMillis();
        int x2 = c2-c1+1;
        int y2 = r2-r1+1;
        int[][] a = new int[y2][x2];
        int x = 5000;
        int y = 5000;
        int count = 1;
        int turn = 0;
        int 방향 = 1;
        int max = 0;
        int turnCount = 1;
//        a[x][y] = count;
        while (count < 10001*10001+1) {
        int x1 = x-5000;
        int y1 = y-5000;
            if ((y-5000 >= r1 && y-5000 <= r2) && x-5000 >= c1 &&x-5000 <= c2) {
                a[y1-r1][x1-c1] = count;
                max = Math.max(count,max);
            }
            count++;
            if (turn == turnCount) { 방향++; turn = 0;}
            if (방향 > 4) 방향=1;
            if (방향 == 1) {
                x++;
//                a[y][x] = count;
                turn++;
            }
            else if (방향 == 2) {
                y--;
//                a[y][x] = count;
                turn++;
            }
            else if (방향 == 3) {
                x--;
//                a[y][x] = count;
                turn++;
                if (turn == turnCount) {
                    if ((y-5000 >= r1 && y-5000 <= r2) && x-5000 >= c1 &&x-5000 <= c2) {
                        a[y1-r1][x1-c1-1] = count;
                        max = Math.max(count,max);
                    }
                    count++;
                    x--;
//                    a[y][x] = count;
                    turn = 0;
                    방향++;
                    turnCount++;
                }
            }
            else if (방향 == 4) {
                y++;
//                a[y][x] = count;
                turn++;
                if (turn == turnCount) {
                    방향 = 1;
                    turn = 0;
                    turnCount++;
                }
            }

        }
        int length = String.valueOf(max).length();
        for (int i = 0; i < r2 - r1 + 1; ++i) {
        String result = "";
            for (int j = 0; j < c2 - c1 + 1; ++j) {
                if (String.valueOf(a[i][j]).length() < length) {
                    result += " ".repeat(length - String.valueOf(a[i][j]).length());
                }
                result += a[i][j]+" ";
            }
            System.out.println(result);
        }
//        int[][] b = new int[y2][x2];
//        for (int i = 0; i < y2; i++) {
//        b[i] = Arrays.copyOfRange(a[5000+r1+i],5000+c1,5000+c2+1);
//        System.out.println(Arrays.toString(a[i]));
//        }
        /** 시간/메모리 확인 */
//        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
//        Runtime.getRuntime().gc();
//        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//        System.out.println(usedMemory/1000/1000 + " MB");
//        System.out.println(afterTime-beforeTime);

    }
}