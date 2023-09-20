class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        int start = 0;
        int last = arr.length-1;
        while (start != last && start < last) {
            if (arr[start] == 2 && arr[last] == 2) break;
            if (arr[start] != 2) start++;
            if (arr[last] != 2) last--;
        }
        if (start == last && arr[start] == 2){answer = new int[1]; answer[0] = 2;}
        else if (arr[start] != 2) {answer = new int[1]; answer[0] = -1;}
        else {
            answer = new int[last-start+1];
                int idx = 0;
            for (int i = start; i <= last; i++) {
                answer[idx] = arr[i];
                idx++;
            }
        }
        return answer;
    }
}