import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    /**
     1번 연산은 배열을 상하 반전
     2번 연산은 배열을 좌우 반전
     3번 연산은 오른쪽으로 90도 회전
     4번 연산은 왼쪽으로 90도 회전
     5번 : 4등분 후 1번 -> 2번, 2번 ->3번, 3 -> 4번, 4-> 1번
     6번 : 1번 -> 4번, 2번 -> 1번, 3번 -> 2번, 4번 -> 3번
     */

    public static void print(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]);
                if (j < m-1) {
                    System.out.print(" ");
                }
            }
            if (i < n-1) {
                System.out.print("\n");
            }
        }
    }

    public static int[][] print2(int[][] arr1, int[][] arr2, int[][] arr3, int[][] arr4) {
        int a = arr1.length;
        int b = arr1[0].length;
        int n = arr1.length * 2;
        int m = arr1[0].length * 2;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < a && j < b) {
                    result[i][j] = arr1[i][j];
                } else if (i < a && j >= b) {
                    result[i][j] = arr2[i][j-b];

                }  else if (i >= a && j < b) {
                    result[i][j] = arr3[i-a][j];

                } else if (i >= a && j >= b) {
                    result[i][j] = arr4[i-a][j-b];
                }
            }
        }
        return result;
    }

    public static int[][] func1(int[][] arr, int n, int m, int r) {
        if (r%2 == 0) {
//            print(arr);
            return arr;
        }
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            result[i] = arr[n-i-1].clone();
        }
//        print(result);
        return result;
    }

    public static int[][] func2(int[][] arr, int n, int m, int r) {
        if (r%2 == 0) {
//            print(arr);
            return arr;
        }
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = arr[i][m-j-1];
            }
        }
        return result;

    }

    public static int[][] func3(int[][] arr, int n, int m, int r) {
        int count = r%4;
        if (count == 0) {
//            print(arr);
            return arr;
        }
        for (int k = 1; k <= count; k++) {
        int nn = arr[0].length;
        int nm = arr.length;
            int[][] result = new int[nn][nm];
            for (int i = 0; i < nm; i++) {
                for (int j = 0; j < nn; j++) {

                    result[j][nm-i-1] = arr[i][j];

                }
            }
            arr = result.clone();
        }

        return arr;


    }

    public static int[][] func4(int[][] arr, int n, int m, int r) {
        int count = r%4;
        if (count == 0) {
//            print(arr);
            return arr;
        }
        for (int k = 1; k <= count; k++) {
        int nn = arr[0].length;
        int nm = arr.length;
            int[][] result = new int[nn][nm];
            for (int i = 0; i < nm; i++) {
                for (int j = 0; j < nn; j++) {

                    result[nn-j-1][i] = arr[i][j];

                }
            }
            arr = result.clone();
        }

        return arr;

    }

    public static int[][] func5(int[][] arr, int n, int m, int r) {
        int count = r%4;
        if (count == 0) {
//            print(arr);
            return arr;
        }
        int a = arr.length/2;
        int b = arr[0].length/2;

        int[][] arr1 = new int[a][b];
        int[][] arr2 = new int[a][b];
        int[][] arr3 = new int[a][b];
        int[][] arr4 = new int[a][b];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int icalc = i/a;
                int jcalc = j/b;
                if (icalc == 0 && jcalc == 0) {
                    arr1[i][j] = arr[i][j];
                } else if (icalc == 0 && jcalc > 0) {
                    arr2[i][j-b] = arr[i][j];
                } else if (icalc > 0 && jcalc == 0) {
                    arr4[i-a][j] = arr[i][j];
                } else if (icalc > 0 && jcalc > 0) {
                    arr3[i-a][j-b] = arr[i][j];
                }

            }
        }
        int[][] result = new int[n][m];
        switch (count) {
            case 1:
                result = print2(arr4, arr1, arr3, arr2);
                break;
            case 2:
                result = print2(arr3, arr4, arr2, arr1);
                break;
            case 3:
                result = print2(arr2, arr3, arr1, arr4);
                break;
        }
        return result;

    }

    public static int[][] func6(int[][] arr, int n, int m, int r) {
        int count = r%4;
        if (count == 0) {
            print(arr);
            return arr;
        }
        int a = arr.length/2;
        int b = arr[0].length/2;

        int[][] arr1 = new int[a][b];
        int[][] arr2 = new int[a][b];
        int[][] arr3 = new int[a][b];
        int[][] arr4 = new int[a][b];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int icalc = i/a;
                int jcalc = j/b;
                if (icalc == 0 && jcalc == 0) {
                    arr1[i][j] = arr[i][j];
                } else if (icalc == 0 && jcalc > 0) {
                    arr2[i][j-b] = arr[i][j];
                } else if (icalc > 0 && jcalc == 0) {
                    arr4[i-a][j] = arr[i][j];
                } else if (icalc > 0 && jcalc > 0) {
                    arr3[i-a][j-b] = arr[i][j];
                }

            }
        }
        int[][] result = new int[n][m];
        switch (count) {
            case 1:
                result = print2(arr2, arr3, arr1, arr4);
                break;
            case 2:
                result = print2(arr3, arr4, arr2, arr1);
                break;
            case 3:
                result = print2(arr4, arr1, arr3, arr2);
                break;
        }
        return result;


    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int [][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int calc = Integer.parseInt(st.nextToken());
            switch (calc) {
            case 1:
                arr = func1(arr, arr.length, arr[0].length, 1);
                break;
            case 2:
                arr = func2(arr, arr.length, arr[0].length, 1);
                break;
            case 3:
                arr = func3(arr, arr.length, arr[0].length, 1);
                break;
            case 4:
                arr = func4(arr, arr.length, arr[0].length, 1);
                break;
            case 5:
                arr = func5(arr, arr.length, arr[0].length, 1);
                break;
            case 6:
                arr = func6(arr, arr.length, arr[0].length, 1);
                break;
        }

        }

        print(arr);

    }
}