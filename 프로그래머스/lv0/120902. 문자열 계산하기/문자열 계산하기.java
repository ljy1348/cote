import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(my_string);
        Pattern pattern2 = Pattern.compile("\\s*([+-])\\s*");
        Matcher matcher2 = pattern2.matcher(my_string);
        matcher.find();
        int a = Integer.parseInt(matcher.group(1));
        answer += a;
        while (matcher.find()) {
            a = Integer.parseInt(matcher.group(1));
            matcher2.find();
            if (matcher2.group(1).equals("+")) answer += a;
            else if (matcher2.group(1).equals("-"))answer -= a;
        }
        return answer;
    }
}