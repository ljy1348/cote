class Solution {
    public long solution(String numbers) {
        long answer = 0;
        String result = "";
        while (numbers.length() > 0) {
            if (numbers.startsWith("zero")) {
                result += "0";
                numbers = numbers.substring(4,numbers.length());
            } else if (numbers.startsWith("one")) {
                result += "1";
                numbers = numbers.substring(3,numbers.length());
            } else if (numbers.startsWith("two")) {
                result += "2";
                numbers = numbers.substring(3,numbers.length());
            } else if (numbers.startsWith("three")) {
                result += "3";
                numbers = numbers.substring(5,numbers.length());
            } else if (numbers.startsWith("four")) {
                result += "4";
                numbers = numbers.substring(4,numbers.length());
            } else if (numbers.startsWith("five")) {
                result += "5";
                numbers = numbers.substring(4,numbers.length());
            } else if (numbers.startsWith("six")) {
                result += "6";
                numbers = numbers.substring(3,numbers.length());
            } else if (numbers.startsWith("seven")) {
                result += "7";
                numbers = numbers.substring(5,numbers.length());
            } else if (numbers.startsWith("eight")) {
                result += "8";
                numbers = numbers.substring(5,numbers.length());
            } else if (numbers.startsWith("nine")) {
                result += "9";
                numbers = numbers.substring(4,numbers.length());
            }
        }
        answer = Long.valueOf(result);
        return answer;
    }
}