class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int num = 0;
        for (int i = 1; i < k; i++ ) {
            num = (i*2)%numbers.length;
            answer = numbers[num];
        }
        if(numbers.length == 1) answer = 1;
        return answer;
    }
}