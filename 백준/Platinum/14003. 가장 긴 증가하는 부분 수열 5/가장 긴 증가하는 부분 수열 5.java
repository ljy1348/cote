import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];
        int[] parent = new int[N];
        ArrayList<Integer> lis = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis.add(arr[0]);
        parent[0] = 0;

        for (int i = 1; i < N; i++) {
            if (arr[i] > lis.get(lis.size() - 1)) {
                lis.add(arr[i]);
                parent[i] = lis.size() - 1;
            } else {
                int idx = lowerBound(lis, arr[i]);
                lis.set(idx, arr[i]);
                parent[i] = idx;
            }
        }

        System.out.println(lis.size());

        for (int i = N - 1, j = lis.size() - 1; i >= 0; i--) {
            if (parent[i] == j) {
                stack.push(arr[i]);
                j--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    public static int lowerBound(ArrayList<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return high;
    }
}