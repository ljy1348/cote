class Solution {
    public String[] solution(String my_str, int n) {
        int size = (int)Math.ceil((double)my_str.length()/(double)n);
        String[] answer = new String[size];
        for (int i = 0; i < size-1; i++) {
            answer[i] = my_str.substring(0,n);
            my_str = my_str.substring(n,my_str.length());
        }
        answer[size-1] = my_str;
        
        return answer;
    }
}