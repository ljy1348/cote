import javax.xml.stream.events.ProcessingInstruction;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer,Boolean> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int speople = Integer.parseInt(st.nextToken());
        for (int i = 0; i < speople; i++) {
            int temp = Integer.parseInt(st.nextToken());
            map.put(temp,true);
        }

        ArrayList<Integer>[] plist = new ArrayList[m+1];
        ArrayList<Integer>[] hlist = new ArrayList[n+1];
        for (int i = 1; i <= m; i++) {
            plist[i] = new ArrayList();
        }
        for (int i = 1; i <= n; i++) {
            hlist[i] = new ArrayList<>();
        }
        boolean[] party = new boolean[m+1];
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int partyPeople = Integer.parseInt(st.nextToken());
            boolean check = false;
            for (int j = 0; j < partyPeople; j++) {
                int temp = Integer.parseInt(st.nextToken());
                plist[i].add(temp);
                hlist[temp].add(i);
                if (map.containsKey(temp)) check = true;
            }
            if (check) {
                que.add(i);
                party[i] = true;
            }
        }
        while (que.size() > 0) {
            int p = que.poll();
            party[p] = true;
            for (int i = 0; i < plist[p].size(); i++) {
                int temp = plist[p].get(i);
                for (int j = 0; j < hlist[temp].size(); j++) {
                    int temp2 = hlist[temp].get(j);
                    if (party[temp2] == false) que.add(temp2);
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= m; i++) {
            if (party[i] == false) count++;
        }
        System.out.println(count);
    }
}