class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] all = new int[n+1];
        // 2 = 잃어버림, 1 = 여분 있음
        for (int i = 0; i < lost.length; i++) {
            all[lost[i]] -= 1;
        }
        for (int i = 0; i < reserve.length; i++) {
            all[reserve[i]] += 1;
        }
        
        for (int i = 1; i < n+1; i++) {
            if (all[i] != 0) {
                if (i > 1 && all[i-1] != 0 & all[i-1] != all[i]) {
                    all[i-1] = 0;
                    all[i] = 0;
                } else if (i < n && all[i+1] != 0 & all[i+1] != all[i]) {
                    all[i+1] = 0;
                    all[i] = 0;
                }
            }
        }
        
        for (int i = 1; i < n+1; i++) {
            if (all[i] >= 0) {
                answer += 1;
            }
        }
        
        return answer;
    }
}