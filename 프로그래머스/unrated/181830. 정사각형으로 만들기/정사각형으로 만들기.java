class Solution {
    public int[][] solution(int[][] arr) {
        int x = 0;
        int y = 0;
        if (arr.length > arr[0].length) {
            x = arr.length - arr[0].length;
        }
        if (arr.length < arr[0].length) {
            y = arr[0].length - arr.length;
        }
        int[][] answer = new int[arr.length+y][arr[0].length+x];
        if (x != 0) {
            for (int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr[0].length; j++) {
                    answer[i][j] = arr[i][j];
                }
            }
        } else
        if (y != 0) {
            for (int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr[0].length; j++) {
                    answer[i][j] = arr[i][j];
                }
            }
        } else answer = arr;
         
        return answer;
    }
}