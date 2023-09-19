class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        String cut1 = my_string.substring(0,s);
        String cut2 = my_string.substring(s+overwrite_string.length(), my_string.length());
        answer = cut1 + overwrite_string + cut2;
        
        return answer;
    }
}