class Solution {
    public int solution(int n) {
         int answer = 0;

        int i = 1;

//        System.out.println(Math.sqrt(n));

        while(i <= Math.sqrt(n)) {
            if (n%i == 0) {
                answer += i;
                if (i != Math.sqrt(n))
                answer += n/i;
            }
            i++;
        }

        System.out.println(answer);
        return answer;
    }
}