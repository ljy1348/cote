class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        int start = 0;
        int idx = 0;
        if (direction.equals("right")) {
            answer[0] = numbers[numbers.length-1];
            idx = 1;
        } else {
            answer[numbers.length-1] = numbers[0];
            start = 1;
        }
        for (int i = 0+start; i<numbers.length-idx; i++) {
            answer[i+idx-start] = numbers[i];
        }
        return answer;
    }
}