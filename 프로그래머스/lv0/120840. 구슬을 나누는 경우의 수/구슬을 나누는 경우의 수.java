import java.math.BigInteger;
class Solution {
    public long solution(int balls, int share) {
        long answer = 0;
        BigInteger bi1 = new BigInteger("1");
        BigInteger bi2 = new BigInteger("1");
        if (balls == share) answer = 1;
        else {
        for (int i = share+1; i <= balls; i++) {
            BigInteger biTemp = new BigInteger(String.valueOf(i));
            bi1 = bi1.multiply(biTemp);
        }
        for (int i = 1; i <= balls-share; i++) {
            BigInteger biTemp = new BigInteger(String.valueOf(i));
            bi2 = bi2.multiply(biTemp);
        }
        }
        answer = bi1.divide(bi2).longValue();
        return answer;
    }
}