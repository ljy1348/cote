import java.util.*;
class Solution {
    boolean solution(String s) {
        if (s.startsWith(")")) return false;
        if (s.endsWith("(")) return false;

        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(') {
                count++;
            } else {
                count--;
                if (count < 0) return false;
            }
        }
        

        return count == 0;
    }
}