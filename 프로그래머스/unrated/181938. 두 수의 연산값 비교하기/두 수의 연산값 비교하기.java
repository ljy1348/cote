class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String result = a+""+b;
        int result1 = Integer.parseInt(result);
        int result2 = 2*a*b;
        answer = Math.max(result1,result2);
            
        
        return answer;
    }
}