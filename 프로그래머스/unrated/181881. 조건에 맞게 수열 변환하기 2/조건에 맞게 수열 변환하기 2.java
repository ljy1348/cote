class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int count = 0;
        while (true) {
            count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2 == 0 && arr[i] >= 50) {
                arr[i] = arr[i]/2;
                count = 1;
            }
            else if (arr[i]%2 == 1 && arr[i] < 50) {
                arr[i] = (arr[i]*2) +1;
                count = 1;
            }
            
        }
            if (count == 0) break;
            answer++;
        }
        
        
        return answer;
    }
}