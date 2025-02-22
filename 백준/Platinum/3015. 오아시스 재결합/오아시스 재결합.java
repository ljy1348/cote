import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Long[]> stack = new Stack<>();
        List<Long> list = new ArrayList<>();
        long count = 0;
        for (int i = 0; i < n; i++) {
            Long now = Long.parseLong(br.readLine());

                while (!stack.isEmpty() && stack.peek()[0] < now) {
                    long a = stack.pop()[1];
                    if (stack.isEmpty()) {
                        list.add(a);
                        if (a > 1) {
                            list.add(1L);
                        }
                    } else {
                        list.add(a + 1);
                    }
                }
                if (!stack.isEmpty() && stack.peek()[0].equals(now)) {
                Long[] temp = stack.pop();
                stack.push(new Long[]{now, temp[1]+1});
                continue;
            }

            if (now == 7994) {
                int ef = 0;}
            stack.push(new Long[]{now, 1L});

        }

        while (!stack.isEmpty()) {
            Long[] temp = stack.pop();
            long a = temp[1];
            if (stack.isEmpty()) {
                a--;
            }
            for (long i = 1; i <= a; i++) {
                count += i;
            }
        }

        for (Long i : list) {
            if (i == 1) {
                count++;
                continue;
            }
            for (long j = 2; j <= i; j++) {
                count += j;
            }
        }

        System.out.println(count);
    }

}