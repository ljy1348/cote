import java.math.BigInteger;
class Solution {
    public int solution(String number) {
        int answer = 0;
        BigInteger bigNum = new BigInteger(number);
        BigInteger bigNine = new BigInteger("9");
        answer = bigNum.mod(bigNine).intValue();
        return answer;
    }
}