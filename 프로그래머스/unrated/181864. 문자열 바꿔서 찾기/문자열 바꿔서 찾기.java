class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        myString = myString.toLowerCase();
        myString = myString.replace("a","B");
        myString = myString.replace("b","A");
        answer = myString.contains(pat) ? 1 : 0;
        return answer;
    }
}