class Solution {
    public String[] solution(String[] strArr) {
        String result = "";
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].contains("ad")) continue;
            result += strArr[i]+" ";
        }
        String[] answer = result.split(" ");
        return answer;
    }
}