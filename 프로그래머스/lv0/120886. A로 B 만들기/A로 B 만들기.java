class Solution {
    public int solution(String before, String after) {
        int answer = 1;
        int[] bef = new int[27];
        int[] aft = new int[27];
        for (int i = 0; i < before.length(); i++) {
            char bcha = before.charAt(i);
            char acha = after.charAt(i);
            bef[bcha - 'a']++;
            aft[acha - 'a']++;
        }
        for (int i = 0; i < bef.length; i++) {
            if (bef[i] != aft[i]) answer = 0;
        }
        return answer;
    }
}