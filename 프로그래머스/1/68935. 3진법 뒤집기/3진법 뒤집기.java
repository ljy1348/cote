class Solution {
    public int solution(int n) {
        int idx = 1;
        int idx2 = 0;
        while (true) {
            if (n/(idx*3) <= 0) {
                break;
            }
            idx = idx*3;
            idx2++;
        }
        StringBuilder numStr = new StringBuilder();
        for (int i = 0; i <= idx2; i++) {
            int temp = n/idx;
            numStr.append(temp);
            n -= temp*idx;
            idx = idx/3;
        }
        String numStr2 = numStr.toString();
        int sum = 0;
        for (int i = idx2; i >= 0; i--) {
            char temp = numStr2.charAt(i);
            int temp2 = Integer.parseInt(String.valueOf(temp));
            int temp3 = 1;
            for (int j = 0; j < i; j++) {
                temp3 *= 3;
            }
            sum += temp3*temp2;
        }
        return sum;
    }
}