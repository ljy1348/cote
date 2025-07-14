import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.
 *
 * add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
 * remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
 * check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
 * toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
 * all: S를 {1, 2, ..., 20} 으로 바꾼다.
 * empty: S를 공집합으로 바꾼다.
 */

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String calc = st.nextToken();
            int x = 0;
            if (st.hasMoreElements()) {
                x = Integer.parseInt(st.nextToken());
            }
            calcData(set, calc, x);
        }

        System.out.println(sb.toString());


    }

    public static void calcData(Set<Integer> set, String calc, int x) {
        if (calc.equals("add")) add(set, x);
        else if (calc.equals("remove")) remove(set, x);
        else if (calc.equals("check")) check(set, x);
        else if (calc.equals("toggle")) toggle(set, x);
        else if (calc.equals("all")) all(set);
        else if (calc.equals("empty")) empty(set);
    }

    public static void check(Set<Integer> set, int x) {
        if (set.contains(x)) {
            sb.append(1).append('\n');
        } else {
            sb.append(0).append('\n');
        }
    }

    public static void add(Set<Integer> set, int x) {
        set.add(x);
    }

    public static void remove(Set<Integer> set, int x) {
        set.remove(x);
    }

    public static void toggle(Set<Integer> set, int x) {
        if (set.contains(x)) {
            remove(set, x);
        } else {
            add(set, x);
        }
    }

    public static void all(Set<Integer> set) {
        int all = 20;
        for (int i = 1; i <= all; i++) {
            set.add(i);
        }
    }

    public static void empty(Set<Integer> set) {
        set.clear();
    }

}