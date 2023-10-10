//# Java code for solving the Longest Increasing Subsequence problem using binary search
//        # Note: This is a textual representation; you should copy it into your Java environment to run it.

//        ```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(st.nextToken()));

        for (int i = 1; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (list.get(list.size() - 1) < temp) {
                list.add(temp);
            } else {
                updateList(temp, list);
            }
        }
        System.out.println(list.size());
    }

    static void updateList(int temp, List<Integer> list) {
        int start = 0;
        int last = list.size() - 1;

        while (start <= last) {
            int idx = (last - start) / 2 + start;
            if (list.get(idx) > temp) {
                last = idx - 1;
            } else if (list.get(idx) < temp) {
                start = idx + 1;
            } else {
                return;
            }
        }
        list.set(start, temp);
    }
}