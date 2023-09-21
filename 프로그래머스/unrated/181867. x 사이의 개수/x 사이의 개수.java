class Solution {
    public int[] solution(String myString) {
        String[] str = myString.split("x");
        int leng = str.length;
        if (myString.charAt(myString.length()-1) == 'x') leng++;
        int[] answer = new int[leng];
        for (int i = 0; i < str.length; i++) {
            answer[i] = str[i].length();
        }
        return answer;
    }
}