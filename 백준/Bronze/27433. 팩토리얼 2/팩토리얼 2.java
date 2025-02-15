import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static long pactorial(int n) {
        if (n <= 1) return 1;
        return n * pactorial(n -1);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long result = pactorial(n);
        System.out.println(result);

    }
}