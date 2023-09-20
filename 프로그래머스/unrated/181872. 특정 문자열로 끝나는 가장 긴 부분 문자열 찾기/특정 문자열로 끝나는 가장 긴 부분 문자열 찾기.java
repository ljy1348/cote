class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        
        for (int i = myString.length()-1; i >= 0; i--) {
            String sub = myString.substring(i,myString.length());
            // System.out.println(sub);
            if (sub.contains(pat)) {
                myString = myString.substring(0,i);
                break;
            }
        }
        answer = myString+pat;
        return answer;
    }
}