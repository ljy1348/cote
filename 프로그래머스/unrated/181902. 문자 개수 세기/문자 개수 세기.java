class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        for (int i = 0; i < my_string.length(); i++) {
            char cha = my_string.charAt(i);
            if (cha >= 'A' && cha <= 'Z') {
                int idx = Integer.valueOf(cha - 'A');  
                answer[idx]++;
            } else if (cha >= 'a' && cha <= 'z') {
                int idx = Integer.valueOf(cha - 'a')+26;
                answer[idx]++;
            }
        }
        return answer;
    }
}