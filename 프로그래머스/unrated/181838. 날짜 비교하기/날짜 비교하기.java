class Solution {
    public int solution(int[] date1, int[] date2) {
        int answer = 0;
        int temp1 = date1[0]*365+date1[1]*30+date1[2];
        int temp2 = date2[0]*365+date2[1]*30+date2[2];
        if (temp1 < temp2) answer = 1;
        
        return answer;
    }
}