import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {


    static List<int[]> list;

    public static void func1(int n, int start, int end, int aux) {
        if (n == 1) {
            int[] temp = new int[2];
            temp[0] = start;
            temp[1] = end;
            list.add(temp);
            return;
        }

        func1(n - 1, start, aux, end);
        int[] temp = new int[2];
        temp[0] = start;
        temp[1] = end;
        list.add(temp);
        func1(n - 1, aux, end, start);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        list = new ArrayList<int[]>();


        func1(input, 1, 3, 2);
        int test = 0;

        System.out.println(list.size());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            sb.append(temp[0] + " " + temp[1]+"\n");
        }
        System.out.println(sb);
    }


}