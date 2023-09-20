import java.util.Arrays;
class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        Arrays.sort(indices);
        for (int i = 0; i < indices.length; i++) {
            String str1 = my_string.substring(0,indices[i]-i);
            String str2 = my_string.substring(indices[i]+1-i,my_string.length());
            my_string = str1+str2;
            
        }
        answer = my_string;
        return answer;
    }
}