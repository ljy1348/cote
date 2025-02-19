class Solution {
    int answer = 0;
    public void dfs(int n, int idx, int target, int calc, int[] arr) {
        int result = 0;
        if (calc == 1) {
            result = n+arr[idx];
        } else {
            result = n-arr[idx];
        }
        
        if ((idx == arr.length-1) && result == target) {
            answer++;
            return;
        }
        if (idx == arr.length-1) {
            return;
        }
        for (int i = 0; i < 2; i++) {
            dfs(result, idx+1, target, i, arr);
        }
        
        return;
    }
    
    
    public int solution(int[] numbers, int target) {
        
        for (int i = 0; i < 2; i++) {
            dfs(0, 0, target, i, numbers);
        }
        
        return answer;
    }
}