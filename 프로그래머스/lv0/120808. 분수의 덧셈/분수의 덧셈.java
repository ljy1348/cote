class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int denom = 0;
        if (denom1 == denom2) {
            denom = denom1;
        } else {
            denom = denom1 * denom2;
            for (int i = 1; i < denom; i++) {
                if (denom1 % i == 0 && denom2 % i == 0) {
                    denom = denom / i;
                }
            }
        }
        int cal1 = (int)(numer1*((double)denom/(double) denom1));
        int cal2 = (int)(numer2*((double)denom/(double) denom2));
        answer[0] = cal1+cal2;
        answer[1] = denom;
        int result = 0;
        for (int i = 1; i <= Math.max(answer[0],answer[1]); i++) {
            if (answer[0]%i == 0 && answer[1]%i == 0) {
                result = i;
            }
        }
        if (result != 0) {
            answer[0] /= result;
            answer[1] /= result;
        }
        
        // System.out.println(cal);
        return answer;
    }
}