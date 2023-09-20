class Solution {
    public String[] solution(String myStr) {
        String[] answer = {};
        myStr = myStr.replaceAll("a", " ");
        myStr = myStr.replaceAll("b", " ");
        myStr = myStr.replaceAll("c", " ");
        myStr = myStr.trim();
        answer = myStr.split("\\s+");
        if (answer[0].equals("")) {answer[0] = "EMPTY";}
        return answer;
    }
}