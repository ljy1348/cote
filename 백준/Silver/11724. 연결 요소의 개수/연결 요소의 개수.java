import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * packageName : backjoon
 * fileName : P11724
 * author : GGG
 * date : 2023-10-02
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-02         GGG          최초 생성
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[n+1];
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            list[idx].add(val);
            list[val].add(idx);
        }
        for (int i = 1; i <= n; i++) {
        if (visit[i]) continue;
        count++;
        func(visit,list,i);
        }
        System.out.println(count);
    }


    static int count = 0;
    static void func(boolean[] visit, ArrayList<Integer>[] list, int num) {
        visit[num] = true;
        if (list[num].isEmpty()) {return;}
        while(list[num].size() > 0) {
            int temp = list[num].get(0);
            list[num].remove(0);
            if (visit[temp]) continue;
            else {
                func(visit,list,temp);
            }
        }
    }
}