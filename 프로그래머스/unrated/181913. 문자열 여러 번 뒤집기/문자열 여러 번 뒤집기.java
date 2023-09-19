class Solution {
    public String solution(String my_string, int[][] queries) {
        for (int i = 0; i < queries.length; i++) {
            String sub = my_string.substring(queries[i][0],queries[i][1]+1);
            String sub2 = "";
            String sub3 = my_string.substring(0,queries[i][0]);
            String sub4 = my_string.substring(queries[i][1]+1, my_string.length());
            for (int j = sub.length()-1; j >=0; j--) {
                sub2 += String.valueOf(sub.charAt(j));
            }
            my_string = sub3+sub2+sub4;
            // System.out.println(my_string);
        }
        String answer = my_string;
        return answer;
    }
}