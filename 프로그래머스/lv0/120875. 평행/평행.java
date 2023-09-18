import java.util.ArrayList;
class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        ArrayList<Double> inclination = new ArrayList<Double>();
        for (int i = 0; i < dots.length-1; i++) {
            for (int j = i+1; j < dots.length; j++) {
                int x = Math.abs(dots[i][0] - dots[j][0]);
                int y = Math.abs(dots[i][1] - dots[j][1]);
                if (x != 0) inclination.add((double)y/(double)x);
            }
        }
        for (int i = 0; i < inclination.size()/2; i++) {
            double ab = inclination.get(i);
            double ac =  inclination.get(inclination.size()-1-i);
            if (ab == ac) {
                answer = 1;
            }
        }
        if (answer > 0) answer = 1;
        return answer;
    }
}