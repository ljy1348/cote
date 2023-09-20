class Solution {
    public int solution(String my_string) {
        int answer = 0;
        int start = -1;
        for (int i = 0; i < my_string.length(); i++) {
            char cha = my_string.charAt(i);
            if ((cha < '0' || cha > '9') && start != -1) {
                String sub = my_string.substring(start,i);
                answer += Integer.parseInt(sub);
                start = -1;
            }
            else if (cha >= '0' && cha <= '9' && start == -1) start = i;
        }
        if (start != -1) {
            String sub = my_string.substring(start,my_string.length());
                answer += Integer.parseInt(sub);
        }
        return answer;
    }
}