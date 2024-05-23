import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int edgesSize = edges.length;
        Map<Integer, int[]> data = new HashMap<>();
        for (int i = 0; i < edgesSize; i++) {
            int str = edges[i][0];
            int dtr = edges[i][1];
            if (!data.containsKey(str)) {
                int[] temp = new int[2];
                temp[0]++;
                data.put(str,temp);
            } else {
                int[] temp = data.get(str);
                temp[0]++;
                data.put(str,temp);
            }
            if (!data.containsKey(dtr)){
                int[] temp = new int[2];
                temp[1]++;
                data.put(dtr,temp);
            } else {
                int[] temp = data.get(dtr);
                temp[1]++;
                data.put(dtr,temp);
            }
        }

            int mapSize = data.size();
            int dot = 0;
            int donut = 0;
            int 막대형 = 0;
            int 숫자형 = 0;
            int max = 0;
        Set<Integer> key = data.keySet();
            Iterator<Integer> iter = key.iterator();
            while (true) {

            if (iter.hasNext()) {
                int i = iter.next();
                int[] temp = data.get(i);
                if (temp[1] == 0 && temp[0] > 1) {
                    dot = i;
                    max = temp[0];
                }
                if ((temp[0] == 2) && (temp[1] == 2 || temp[1] == 3)) {
                    숫자형++;
                }
                if (temp[0] == 1 && temp[1] == 2) {
                    temp[1]--;
                }
                if (temp[0] == 0) {
                    막대형++;
                }
            } else {
                break;
            }
            }

            donut = max - 막대형 - 숫자형;
//        System.out.println("새로 찍은 점 : "+dot);
//        System.out.println("도넛형 : "+(max-막대형-숫자형));
//        System.out.println("막대형 : "+막대형);
//        System.out.println("숫자형 : "+숫자형);
            int[] answer = {dot, donut, 막대형, 숫자형};
            return answer;
    }
}