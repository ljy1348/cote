class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int sum = 0;
        for (int i = -1000; i < 1000; i++) {
            for (int j = 0; j < num; j++) {
                sum += i+j;
            }
            if (sum == total) {
                sum = i;
                break;
            }
            else sum = 0;
        }
        for (int i = 0; i < num; i++) {
            answer[i] = i+sum;
        }
        
        return answer;
    }
}