class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0,9999999};
        
        int start = 0;
        int last = 0;
        int sum = 0;
        
        while(start < sequence.length) {
            if (last >= sequence.length) last = sequence.length-1;
            sum += sequence[last];
            // System.out.println(start+":"+last+":"+sum);
            if (sum < k) {
                last++;
                if (last >= sequence.length) break;
            }
            else if (sum > k) {
                sum -= sequence[start];
                sum -= sequence[last];
                start++;
            }
            else if (sum == k) {
                int[] result = {start, last};

                sum -= sequence[start];
                sum -= sequence[last];
                start++;
                
                
                
                if (result[1]-result[0] < answer[1]-answer[0])
                answer = result;
                
                // sum = 0;
            }
            
        }
        
        return answer;
    }
}