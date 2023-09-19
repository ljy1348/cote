class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int x = 0;
        int c = 0;
        String[] cut = polynomial.split(" ");
        for (int i = 0; i < cut.length; i+=2) {
            if (cut[i].charAt(cut[i].length()-1)=='x') {
                String a = cut[i].substring(0,cut[i].length()-1);
                if (a.equals("")) a = "1";
                x += Integer.parseInt(a);
            } else {
                c += Integer.parseInt(cut[i]);
            }

        }
        if (c == 0) {if (x == 1) answer = "x"; else answer = x+"x";}
        else if (x == 0) answer = String.valueOf(c);
        else {if (x == 1) answer = "x + "+c; else answer = x+"x + "+c;}
        return answer;
    }
}