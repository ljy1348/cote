class Solution {
    public String solution(String my_string) {
        String answer = "";
        for (int i = 0; i < my_string.length()-1; i++) {
            String sub = my_string.substring(i+1,my_string.length());
            String sub2 = my_string.substring(0,i+1);
            String cha = String.valueOf(my_string.charAt(i));
            if (sub.contains(cha)) {
                my_string = sub2+sub.replaceAll(cha,"");
            } 
        }
        
        return answer = my_string;
    }
}