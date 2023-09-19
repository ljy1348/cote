import java.math.BigInteger;
class Solution {
    public String solution(String a, String b) {
        String answer = "";
        BigInteger b1 = new BigInteger(a);
        BigInteger b2 = new BigInteger(b);
        b1 = b1.add(b2);
        answer = b1.toString();
        return answer;
    }
}