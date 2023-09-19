class Solution {
    public int solution(int chicken) {
        int answer = 0;
        while (chicken > 9) {
           answer += (int)chicken/10;
            chicken = (int)chicken/10+chicken%10;
        }
        return answer;
    }
}