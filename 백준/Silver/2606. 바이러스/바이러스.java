import java.io.*;
import java.util.*;

public class Main {
    
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int nodes = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        
        
        ArrayList<Integer>[] listArr = new ArrayList[nodes+1];
        boolean[] visit = new boolean[nodes+1];
        
        for (int i = 1; i <= nodes; i++) {
            listArr[i] = new ArrayList<Integer>();
        }
        
        for (int i = 1; i <= edges; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            listArr[now].add(next);
            listArr[next].add(now);
        }
        
        recursive(listArr, visit, 1);
        System.out.println(count-1);
       
    }
    
    public static void recursive(ArrayList<Integer>[] listArr, boolean[] visit, int now) {
        
        if (visit[now]) {
            return;
        }
        
        visit[now] = true;
        count++;
        ArrayList<Integer> list = listArr[now];
        for (Integer next : list) {
            recursive(listArr, visit, next);
        }
    }


}