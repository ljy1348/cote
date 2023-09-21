import java.util.ArrayList;
class Solution {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < numlist.length; i++) {
            if (numlist[i]%n == 0) list.add(numlist[i]);
        }
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}