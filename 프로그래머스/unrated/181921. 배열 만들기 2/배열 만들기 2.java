class Solution {
    public int[] solution(int l, int r) {
        
        String result = "";
        boolean bool = false;
        for (int i = l; i <= r; i++) {
            if (i%5 == 0) {
                String num = String.valueOf(i);
                for (int j = 0; j < num.length(); j++) {
                    char numChar = num.charAt(j);
                    if (!(numChar == '5' || numChar == '0')) bool = true;
                }
                if (bool == false) result += i+" ";
                bool = false;
            }
        }
        String[] resultNum = result.split(" ");
        if (result.equals("")) {
            int[] answer = {-1};
            return answer;
        } else {
            int[] answer = new int[resultNum.length];
        for (int i = 0; i < resultNum.length; i++) {
            answer[i] = Integer.parseInt(resultNum[i]);
        }
        return answer;
        }
    }
}