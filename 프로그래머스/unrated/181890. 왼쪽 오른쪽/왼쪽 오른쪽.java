class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        
        int i = 0;
        int count = 0;
        while (i < str_list.length) {
            if (str_list[i].equals("l")) {count = 1; break;}
            if (str_list[i].equals("r")) {count = 2; break;}
            i++;
        }
        if (count == 0) return answer;
        else if (count == 1) {
            answer = new String[i];
            for (int j = 0; j < i; j++) {
                answer[j] = str_list[j];
            }
        } else if (count == 2) {
            answer = new String[str_list.length-1-i];
            for (int j = i+1; j < str_list.length; j++) {
                answer[j-(i+1)] = str_list[j];
            }
        }
        
        
        return answer;
    }
}