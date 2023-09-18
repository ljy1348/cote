class Solution {
    public int solution(int[] common) {
        int answer = 0;
        boolean result = true;
            if (common[1]-common[0] == common[common.length-1]-common[common.length-2]) {
                result = false;
            } else {
                result = true;
            }
        if (result == true) {
            int cal = common[common.length-1]/common[common.length-2];
            answer = common[common.length-1]*cal;
        } else {
            int cal = common[1]-common[0];
            answer = common[common.length-1]+cal;
        }
        
        
        return answer;
    }
}