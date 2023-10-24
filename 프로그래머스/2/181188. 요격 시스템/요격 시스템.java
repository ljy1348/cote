import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int solution(int[][] targets) {
                Arrays.sort(targets,(o1,o2)->{return o1[0]-o2[0];});
        int answer = 0;
        ArrayList<int[]> arr = new ArrayList();
        arr.add(targets[0]);
        fori:
        for(int i = 1; i < targets.length; i++) {
            int[] temp = Arrays.copyOf(targets[i],2);

                int j = arr.size()-1;
                int[] arrTemp = arr.get(j);
                if (temp[0] < arrTemp[0] && temp[1] > arrTemp[0]) {
                    arrTemp[0] = Math.max(temp[0],arrTemp[0]);
                    arrTemp[1] = Math.min(temp[1], arrTemp[1]);
                    arr.set(j, arrTemp);
//                    System.out.println("시작값이 포함 : "+temp[0]+","+temp[1]);
                    continue fori;
                }
                else if (temp[1] > arrTemp[1] && temp[0] < arrTemp[1]) {
                    arrTemp[0] = Math.max(temp[0],arrTemp[0]);
                    arrTemp[1] = Math.min(temp[1], arrTemp[1]);
                    arr.set(j, arrTemp);
//                    System.out.println("끝값이 포함 : "+temp[0]+","+temp[1]);
                    continue fori;
                }
                else if (temp[0] > arrTemp[0] && temp[0] < arrTemp[1]){
                    arrTemp[0] = Math.max(temp[0],arrTemp[0]);
                    arrTemp[1] = Math.min(temp[1], arrTemp[1]);
                    arr.set(j, arrTemp);
//                    System.out.println("시작값이 포함2 : "+temp[0]+","+temp[1]);
                    continue fori;
                }
                else if (temp[1] < arrTemp[1] && temp[1] > arrTemp[0]){
                    arrTemp[0] = Math.max(temp[0],arrTemp[0]);
                    arrTemp[1] = Math.min(temp[1], arrTemp[1]);
                    arr.set(j, arrTemp);
//                    System.out.println("끝값이 포함2 : "+temp[0]+","+temp[1]);
                    continue fori;
                }

//            System.out.println(temp[0]+","+temp[1]);
            arr.add(temp);
        }
        return arr.size();
    }
}