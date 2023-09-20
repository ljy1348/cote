class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        String result = "";
        for (int i = 0; i < intStrs.length; i++) {
            int num = Integer.parseInt(intStrs[i].substring(s,s+l));
            if (num>k) result += num+" ";
        }
        String[] str = result.split(" ");
        int[] answer = new int[str.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(str[i]);
        }
        return answer;
    }
}