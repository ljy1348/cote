import static java.lang.Math.*;
class Solution {
        public int[] solution(int n, int m) {

                int min = min(n,m);
        int max = max(n,m);
        int minIndex = 0;
        int idx = 1;
        int temp = 0;
        while (true) {
            if (min % idx == 0) {
                temp = min/idx;
                if (max % temp == 0) {
                    minIndex = temp;
                    break;
                }
            }
            idx++;
        }
        idx = 1;
        temp = 0;
        int maxIndex = 0;
        while (true) {
            temp = min * idx;
            if (temp % max == 0) {
                maxIndex = temp;
                break;
            }
            idx++;

        }


        int[] answer = {minIndex, maxIndex};
        return answer;
    }
}