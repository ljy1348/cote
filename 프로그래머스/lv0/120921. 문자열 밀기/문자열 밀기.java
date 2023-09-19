class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        boolean bool = true;
        for (int i = 0; i < A.length(); i++) {
            String cut1 = A.substring(0,A.length()-i);
            String cut2 = A.substring(A.length()-i, A.length());
            if (B.equals(cut2+cut1)) {
                answer = i;
                bool = false;
                break;
            }
        }
        if (bool == true) answer = -1;
        return answer;
    }
}