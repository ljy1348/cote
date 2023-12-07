import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character,Integer> map = new HashMap(); 
        for(int i = 0; i < s.length(); i++) {
            char tempChar = s.charAt(i);
            
            if (map.containsKey(tempChar)) {
                answer[i] = i - map.get(tempChar);
                map.put(tempChar, i);
            } else {
                answer[i] = -1;
                map.put(tempChar, i);
            }
        }
        return answer;
    }
}