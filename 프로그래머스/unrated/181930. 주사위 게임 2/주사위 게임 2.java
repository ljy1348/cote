class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        int count = 0;
        if (a == b) count++;
        if (b == c) count++;
        if (a == c) count++;
        switch(count) {
            case 0 : answer = a+b+c; break;
            case 1 : answer = (a+b+c)*(a*a+b*b+c*c); break;
            case 3 : answer = (a+b+c)*(a*a+b*b+c*c)*(a*a*a+b*b*b+c*c*c); break;
        }
        return answer;
    }
}