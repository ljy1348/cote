import java.util.Arrays;
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int[] copy = new int[1000];
        Arrays.fill(copy, 0);
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            copy[array[i]]++;
        }
        boolean count = false;
        for (int i = 0; i < copy.length; i++) {
            if (max == copy[i] ) count = true;
            else if (max < copy[i]) {
                answer = i;
                max = copy[i];
                count = false;
        }
        }
        if (count) answer = -1; 
        return answer;
    } 
}