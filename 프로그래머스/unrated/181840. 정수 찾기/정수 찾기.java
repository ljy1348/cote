class Solution {
    public int solution(int[] num_list, int n) {
        int answer = 0;
        for (int val : num_list) if (n == val) answer = 1;
        return answer;
    }
}