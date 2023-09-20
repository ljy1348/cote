class Solution {
    public int[] solution(int[] arr) {
        int two = 1;
        while (two < arr.length) {
            two *= 2;
        }
        int[] answer = new int[two];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i];
        }
            
            
            return answer;
    }
}