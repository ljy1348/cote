import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        /**
         * 첫째 줄에 N과 K가 주어진다. (1 ≤ N, K ≤ 300,000)
         *
         * 다음 N개 줄에는 각 보석의 정보 Mi와 Vi가 주어진다. (0 ≤ Mi, Vi ≤ 1,000,000)
         *
         * 다음 K개 줄에는 가방에 담을 수 있는 최대 무게 Ci가 주어진다. (1 ≤ Ci ≤ 100,000,000)
         *
         * 모든 숫자는 양의 정수이다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] jual = new int[n][2];
        int[] bag = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jual[i][0] = Integer.parseInt(st.nextToken());
            jual[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jual, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(bag);
        int idx = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long result = 0;
        boolean flag = true;
        for (int i = 0; i < k; i++) {
            int size = bag[i];
            int m = jual[idx][0];

            while (m <= size && idx < n && flag) {

                int price = jual[idx][1];
                maxHeap.add(price);
                if (idx == n -1) {
                    flag = false;
                    break;
                }
                idx++;
                m = jual[idx][0];
            }
            if (maxHeap.size() > 0) {
                result += maxHeap.poll();
            }
        }

        System.out.println(result);







    }


}