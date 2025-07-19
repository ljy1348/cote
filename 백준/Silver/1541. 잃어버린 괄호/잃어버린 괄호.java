import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        char[] chars = input.toCharArray();

        boolean 괄호시작 = false;

        long plus = 0;
        long minus = 0;
        StringBuilder nowSumStr = new StringBuilder();

        for (char now : chars) {

            if (now >= '0' && now <= '9') {
                nowSumStr.append(now);
            } else if (now == '-') {
               
                if (괄호시작) {
                    minus += Integer.parseInt(nowSumStr.toString());
                } else {
                    plus += Integer.parseInt(nowSumStr.toString());
                }
                nowSumStr = new StringBuilder();
                괄호시작 = true;
            } else if (괄호시작) {
                minus += Integer.parseInt(nowSumStr.toString());
                nowSumStr = new StringBuilder();
            } else {
                plus += Integer.parseInt(nowSumStr.toString());
                nowSumStr = new StringBuilder();
            }
        }

        if (괄호시작) {
            minus += Integer.parseInt(nowSumStr.toString());
        } else {
            plus += Integer.parseInt(nowSumStr.toString());
        }

        System.out.println(plus - minus);

    }

}