import java.util.regex.*;
class Solution {
    public int solution(String binomial) {
        int answer = 0;
        Pattern pattern = Pattern.compile("(\\d+)\\s+([*+-])\\s+(\\d+)");
        Matcher matcher = pattern.matcher(binomial);
        matcher.find();
        int a = Integer.parseInt(matcher.group(1));
        int b = Integer.parseInt(matcher.group(3));
        if (matcher.group(2).equals("+")) answer = a+b;
        if (matcher.group(2).equals("*")) answer = a*b;
        if (matcher.group(2).equals("-")) answer = a-b;
        
        return answer;
    }
}