class Solution {
    public int solution(int[] array, int n) {
        int answer = 999;
        int min = 999;
        int minValue = 999;
        for (int i = 0; i < array.length; i++) {
            if (min >= Math.abs(array[i] - n)) { 
                if (min == Math.abs(array[i]-n) && answer < array[i]) continue;
                answer = array[i];
                min = Math.abs(array[i]-n);
                }
        }
        return answer;
    }
}