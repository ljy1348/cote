import java.util.ArrayList;
class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i<arr.length; i++) {
            if (list.size() == 0) list.add(arr[i]);
            else if (list.size() > 0) { 
                if (list.get(list.size()-1) == arr[i]) {
                list.remove(list.size()-1);
            } else {
                    list.add(arr[i]);
                }
        }
        }
        if (list.size() == 0) list.add(-1);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}