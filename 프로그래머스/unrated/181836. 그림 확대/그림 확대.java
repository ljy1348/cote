class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[(picture.length*k)];
        for (int i = 0; i < picture.length; i++) {
            String result = "";
            for (int j = 0; j < picture[i].length(); j++) {
                char cha = picture[i].charAt(j);
                for (int m = 0; m < k; m++) {
                    result += String.valueOf(cha);
                }
            }
            for (int m = 0; m < k; m++) {
              answer[i*k+m] = result;  
            }

        }
        
        return answer;
    }
}