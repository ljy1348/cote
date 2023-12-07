import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 탑 바텀 dp
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int house = Integer.parseInt(br.readLine());
        int[][] houseArray = new int [house][3];
        StringTokenizer st;
        for (int i = 0; i < house; i++) {
            st = new StringTokenizer(br.readLine());
            houseArray[i][0] = Integer.parseInt(st.nextToken());
            houseArray[i][1] = Integer.parseInt(st.nextToken());
            houseArray[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = house-2; i >= 0 ; i--) {
            for (int j = 0; j < 3; j++) {
            int first = j+1;
            int second = j+2;
            if (first > 2) first = first - 3;
            if (second > 2) second = second - 3;
            int temp = houseArray[i][j] + houseArray[i+1][first];
            int temp2 = houseArray[i][j] + houseArray[i+1][second];
            houseArray[i][j] = Math.min(temp, temp2);
            }



        }
        int answer = houseArray[0][0];
        for (int i = 1; i < 3; i++) {
            answer = Math.min(answer,houseArray[0][i]);
        }
        System.out.println(answer);

    }
}