import java.util.*;
class Solution {
    public Integer[] solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < intervals.length; i++) {
            for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
                list.add(arr[j]);
            }
        }
        Integer[] answer = list.toArray(new Integer[list.size()]);
        return answer;
    }
}