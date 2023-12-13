import java.util.HashMap;
import java.util.Map;

class Solution {
public  String scoreResult (int a, int b, char c1, char c2) {
        if (a < b) {
            return c2+"";
        } else {
            return c1+"";
        }
    }

    public  String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> score = new HashMap<>();

        score.put('R', 0);
        score.put('T', 0);
        score.put('C', 0);
        score.put('F', 0);
        score.put('J', 0);
        score.put('M', 0);
        score.put('A', 0);
        score.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            if (choices[i] > 4) {
                score.put(survey[i].charAt(1),score.get(survey[i].charAt(1))+ choices[i] - 4);
            } else if (choices[i] < 4) {
                score.put(survey[i].charAt(0), score.get(survey[i].charAt(0))+ 4 - choices[i]);
            }
        }
        answer += scoreResult(score.get('R'), score.get('T'), 'R', 'T');
        answer += scoreResult(score.get('C'), score.get('F'), 'C', 'F');
        answer += scoreResult(score.get('J'), score.get('M'), 'J', 'M');
        answer += scoreResult(score.get('A'), score.get('N'), 'A', 'N');


        System.out.println(answer);

        return answer;
    }
}