import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] stArr = br.readLine().split(" ");
    int n = Integer.parseInt(stArr[0]);
    int m = Integer.parseInt(stArr[1]);

    Set<String> set = new HashSet<>();
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        String str = br.readLine();
        set.add(str);
    }
    for (int i = 0; i < m; i++) {
        String str = br.readLine();
        if (set.contains(str)) list.add(str);
    }
        Collections.sort(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}