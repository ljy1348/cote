class Solution {
    public int[] solution(int[][] score) {
        double [][] avg = new double[score.length][2];
        for (int i = 0; i < score.length; i++) {
            avg[i][0] = (double)(score[i][0]+score[i][1])/2.0;
            avg[i][1] = (double)i;
        }
        for (int k = 0; k < score.length; k++) {
        for (int i = 0; i < score.length-1; i++) {
            if (avg[i][0] > avg[i+1][0]) {
                double [] temp = avg[i];
                avg[i] = avg[i+1];
                avg[i+1] = temp;
            }
        }
        }
        int [] result = new int [score.length];
        for (int i = 0; i < score.length; i++) {
            for(int j = 0; j < score.length; j++) {
                if (avg[i][0] == avg[j][0]) result[(int)avg[j][1]] = score.length-i;
            }
            
            // if (i == 0) result[avg[i][1]] = score.length;
            // else {
            //     if (avg[i-1][0] == avg[i][0]) result[avg[i-1][1]] = score.length-i;
            //     result[avg[i][1]] = score.length-i;
            // }
        }
        int[] answer = result;
        return answer;
    }
}