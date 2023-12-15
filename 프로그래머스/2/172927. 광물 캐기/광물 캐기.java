import java.util.Arrays;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int diaPicks = picks[0];
        int ironPicks = picks[1];
        int stonePicks = picks[2];
        int picksCount = diaPicks+ironPicks+stonePicks;

        if (picksCount*5 < minerals.length) minerals = Arrays.copyOfRange(minerals,0,picksCount*5);


        int[][] stress = new int[(minerals.length/5)+1][3];

        for (int i = 0; i < minerals.length; i++) {
            if (minerals[i].equals("diamond")) {
                stress[(int)Math.floor(i/5)][0]++ ;
            } else if (minerals[i].equals("iron")) {
                stress[(int)Math.floor(i/5)][1]++;
            } else if (minerals[i].equals("stone")) {
                stress[(int)Math.floor(i/5)][2]++;
            }
        }

        Arrays.sort(stress,(o1,o2)->{
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            } else if (o1[1] != o2[1]) {
                return o2[1] - o1[1];
            } else {
                return o2[2] - o1[2];
            }

        });
        int i = 0;
        while (picksCount > 0) {
            if (i >= stress.length) break;
            if (diaPicks > 0) {
                answer += stress[i][0]+stress[i][1]+stress[i][2];
                diaPicks--;
                picksCount--;
            } else if (ironPicks > 0) {
                answer += stress[i][0]*5+stress[i][1]+stress[i][2];
                ironPicks--;
                picksCount--;
            } else if (stonePicks > 0 ) {
                answer += stress[i][0]*25+stress[i][1]*5+stress[i][2];
                stonePicks--;
                picksCount--;
            }
            i++;

        }


        return answer;
    }
}