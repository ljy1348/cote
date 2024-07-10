class Solution {
    public int solution(String t, String p) {
        int pleng = p.length();
        int tleng = t.length();
        int result = 0;
        for (int i = 0; i < t.length()-pleng+1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i+pleng; j++) {
                char temp = t.charAt(j);
                sb.append(temp);
            }
            long a = Long.valueOf(sb.toString());
            long b = Long.valueOf(p);
            if (a <= b) {
                result++;
            }
        }
        return result;
    }
}