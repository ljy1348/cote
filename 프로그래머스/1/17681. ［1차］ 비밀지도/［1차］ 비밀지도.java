import java.util.Arrays;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
            for (int i = 0; i < n; i++) {
                String arr1String = Integer.toBinaryString(arr1[i]);
                String arr2String = Integer.toBinaryString(arr2[i]);
                int arr1Length = n - arr1String.length();
                int arr2Length = n - arr2String.length();
                if (arr1String.length() < n) for (int j = 0; j < arr1Length; j++) {
                    arr1String = "0"+arr1String;
                }
                if (arr2String.length() < n) for (int j = 0; j < arr2Length; j++) {
                    arr2String = "0"+arr2String;
                }
                String temp = "";
                for (int j = 0; j < n; j++) {
                    char arr1Char = arr1String.charAt(j);
                    char arr2Char = arr2String.charAt(j);
                    if (arr1Char == arr2Char && arr1Char == '0') temp += " ";
                    else temp += "#";
                }
                answer[i] = temp;
            }
            System.out.println(Arrays.toString(answer));
            return answer;
    }
}