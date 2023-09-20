class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for (; i <= j; i++) {
            String str = String.valueOf(i);
            for (int m = 0; m < str.length(); m++) {
                if (str.charAt(m) == Integer.toString(k).charAt(0)) answer++;
            }
        }
        
        return answer;
    }
}