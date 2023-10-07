import java.util.Scanner;

public class Main {
        static Scanner sc = new Scanner(System.in);
        static int n = sc.nextInt();
        static int m = sc.nextInt();

    public static void main(String[] args) {

        int[] arr = new int[m];
        func(arr,0,0);

    }
    static void func(int[] arr,int num, int idx) {
        if (idx >= m) return;
        for (int i = num+1; i <= n; i++) {
            arr[idx] = i;
            func(arr,i,idx+1);
            if(idx == m-1) {
                String str = "";
                for (int j = 0; j < m; j++) {
                    if (j == m-1) str += String.valueOf(arr[j]);
                    else str += arr[j]+" ";
                }
                System.out.println(str);
            }
        }
    }
}