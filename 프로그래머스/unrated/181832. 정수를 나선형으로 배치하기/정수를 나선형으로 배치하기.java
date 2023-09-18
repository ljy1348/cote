class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int count = 1;
        int flag = 0;
        int turn = 0;
        int i = 0;
        int j = 0;
        int test = 0;
        String testR = "";
        while (count <= n*n) {
            if (flag == 0) {
                answer[i][j] = count;
                // System.out.println(count);
                j++;
                count++;
                if (j+turn == n) {
                    flag++;
                    j--;
                }
            }
            if (flag == 1) {
                i++;
                if (i+turn == n) {
                    i--;
                    flag++;
                } else {
                    answer[i][j] = count;
                    count++;
                }
            }
            if (flag == 2) {
                j--;
                if (j == turn-1) {
                    flag++;
                    j++;
                } else {
                    answer[i][j] = count;
                    count++;
                }
            }
            if (flag == 3) {
                i--;
                if (i == turn) {
                    flag = 0;
                    i++;
                    j++;
                    turn++;
                } else {
                    if (count>n*n) break;
                    answer[i][j] = count;
                    // System.out.println(count);
                    count++;
                }
            }
            // System.out.println(i+","+j+","+count+","+flag);
            if (count>n*n) break;
        }

        for(int a = 0; a < n; a++) {
            for(int b = 0; b < n; b++) {
                testR += answer[a][b];
            }
            testR += "\n";
        }
        
        return answer;
    }
}