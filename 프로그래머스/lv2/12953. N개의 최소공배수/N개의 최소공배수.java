class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        boolean bool = true;
        int i = 1;
        int debug = 0;
        while (bool) {
            i++;
            for (int j = 0; j < arr.length; j++) {
                if (i%arr[j]==0 && i >= arr[j]) bool = false;
                else  {bool = true; break;}
            }
        }
        return answer=i;
    }
}