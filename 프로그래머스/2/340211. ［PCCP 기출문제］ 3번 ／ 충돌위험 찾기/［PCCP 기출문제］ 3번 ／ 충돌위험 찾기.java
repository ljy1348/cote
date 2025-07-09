import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        List<List<int[]>> mainlist = new ArrayList<>();
        Map<Integer, List<int[]>> map = new HashMap<>();
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        
        for (int[] route : routes) {
            int time = 1;
            for (int i = 0; i < route.length-1; i++) {
                int[] now = points[route[i]-1];
                int[] next = points[route[i+1]-1];
                
                int y = next[0] - now[0];
                int x = next[1] - now[1];
                
                int nowy = now[0];
                int nowx = now[1];
                
                if (time == 1) {
                    int[] start = {nowy, nowx};
                    String nowString = getString(start,time);
                    if (set1.contains(nowString)) {
                        set2.add(nowString);
                    } else {
                        set1.add(nowString);
                    }
                }
                
                if (y > 0) {
                    for (int j = y; j > 0; j--) {
                        int[] temp = {++nowy,nowx};
                        time++;
                        String nowString = getString(temp,time);
                        if (set1.contains(nowString)) {
                            set2.add(nowString);
                        } else {
                            set1.add(nowString);
                        }
                    }
                } else if (y < 0) {
                    for (int j = y; j < 0; j++) {
                        int[] temp = {--nowy,nowx};
                        time++;
                        String nowString = getString(temp,time);
                        if (set1.contains(nowString)) {
                            set2.add(nowString);
                        } else {
                            set1.add(nowString);
                        }
                    }
                }
                
                if (x > 0) {
                    for (int j = x; j > 0; j--) {
                        int[] temp = {nowy,++nowx};
                        time++;
                        String nowString = getString(temp,time);
                        if (set1.contains(nowString)) {
                            set2.add(nowString);
                        } else {
                            set1.add(nowString);
                        }
                    }
                } else if (x < 0) {
                    for (int j = x; j < 0; j++) {
                        int[] temp = {nowy,--nowx};
                        time++;
                        String nowString = getString(temp,time);
                        if (set1.contains(nowString)) {
                            set2.add(nowString);
                        } else {
                            set1.add(nowString);
                        }
                    }
                }
                
                
                
                
                
                
            }
            
        }
        
        return set2.size();
    }
    
    public String getString(int[] arr, int time) {
        return  String.valueOf(time)+","+String.valueOf(arr[0])+","+String.valueOf(arr[1]);
    }
}