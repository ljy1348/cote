class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int x = 0;
        int y = 0;
        int [] max = {0,0};
        int j = 0;
        for (int i = 1; i < dots.length; i++) {
            if (dots[i][1]-dots[0][1] == 0 || dots[i][0]-dots[0][0]==0) {
                y = Math.abs(dots[i][1]-dots[0][1]);
                x = Math.abs(dots[i][0]-dots[0][0]);
                max[j] = Math.max(x,y);
                j++;
            }
        }
        
        
        return answer = max[0] * max[1];
    }
}