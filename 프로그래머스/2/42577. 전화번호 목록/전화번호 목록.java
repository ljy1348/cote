import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Map<String, Boolean> map = new HashMap<>();
        boolean[] arr = new boolean[21];
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));
        for (String phone : phone_book) {
            for (int i = 0; i < 21; i++) {
                if (arr[i]) {
                    String sub;
                    if (i > phone.length()) {
                        sub = phone;
                    } else {
                        sub = phone.substring(0, i);    
                    }
                    
                    if (map.containsKey(sub)) {
                        answer = false;
                    }
                }
            }
            if (!answer) {
                break;
            }
            arr[phone.length()] = true;
            map.put(phone, true);
        }
        
        
        return answer;
    }
}