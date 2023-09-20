class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        String result = "";
        for (int i = e; i >= s; i--) {
            result += String.valueOf(my_string.charAt(i));
        }
        String sub = my_string.substring(s,e+1);
        answer = my_string.replace(sub,result);
        return answer;
    }
}