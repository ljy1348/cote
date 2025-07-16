import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int notSeeCount = Integer.parseInt(st.nextToken());
        int notListenCount = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        while (--notSeeCount >= 0) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>();

        while (--notListenCount >= 0) {
            String name = br.readLine();
            if (set.contains(name)) {
                list.add(name);
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (String name : list) {
            sb.append(name).append("\n");
        }

        System.out.println(sb.toString());


    }


}