import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Main {


    static int input;


    static void pactorial(String star, int n) {
        String[][] arr = new String[3][3];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (i == 1 && j == 1) {
                    String temp = "";
                    String[] startArr = star.split("\n");
                    for (int k = 0; k < startArr.length; k++) {
                        for (int l = 0; l < startArr.length; l++) {
                            sb.append(" ");
                        }
                        if (k < startArr.length-1) sb.append("\n");
                    }
                    arr[i][j] = sb.toString();
                } else {
                    arr[i][j] = star;
                }

            }

        }


        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = "";
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String[] temp = arr[i][j].split("\n");
                for (int k = 0; k < temp.length; k++) {
                    result[i*temp.length+k] += temp[k];
                }
            }
        }

        StringBuilder returnStr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            returnStr.append(result[i]);
            if (i < n-1) returnStr.append("\n");
        }
        if (n*3 > input) {
            System.out.println(returnStr);
            return;
        }

        pactorial(returnStr.toString(), n*3);
        return;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = Integer.parseInt(br.readLine());

        pactorial("*", 3);

//        System.out.println(printStr);


    }
}