class Solution {
    public int solution(int n) {
        int answer = 1;
        int num = 1;
        for (int i = 1; i <= n; i ++) {
            answer *= i;
            if (answer > n) {
                answer = i-1;
                break;
        } else if (answer == n) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
