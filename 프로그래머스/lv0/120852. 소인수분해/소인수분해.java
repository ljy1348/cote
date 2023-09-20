class Solution {
    public int[] solution(int n) {
        int i = 2;
        String result = "";
        int isNum = 0;
        while (n != 1) {
            if (n%i == 0) {
                n = n/i;
                if (isNum != i) {
                    result += i+" ";
                    isNum = i;
                }
            }
            else {
                i++;
            }
        }
        String[] str = result.split(" ");
        int[] answer = new int[str.length];
        for (int j = 0; j < str.length; j++) {
            answer[j] = Integer.parseInt(str[j]);
        }
        return answer;
    }
}