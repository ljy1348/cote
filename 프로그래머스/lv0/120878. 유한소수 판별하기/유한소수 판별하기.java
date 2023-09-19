class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        boolean bool = false;
        int dbs = 0;
        for (int i = 1; i <= Math.max(a,b); i++) {
            if (a%i == 0 && b%i == 0) {
                dbs = i;
            }
        }
        if (a == b) dbs = a;
        a = a/dbs;
        b = b/dbs;
        System.out.println(dbs);
        while (true) {
            if (b%2 == 0) {b = b/2; continue;}
            if (b%5 == 0) {b = b/5; continue;}
            break;
        }
        // for (int i = 2; i < b/2; i++) {
        //     if (b%i == 0) bool = true;
        // }
        if (b%2 == 0 || b % 5 == 0 || b == 1) bool = true;
            System.out.println(bool+","+b);
            
        if (bool == true) answer = 1;
        else answer = 2;
        
        return answer;
    }
}