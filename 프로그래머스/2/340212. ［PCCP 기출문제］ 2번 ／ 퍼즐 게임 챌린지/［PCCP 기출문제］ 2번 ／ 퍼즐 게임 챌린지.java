class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int min = 1;
        int max = 0;
        for (int diff : diffs) {
            max = Math.max(diff, max);
        }
        int level = 1;
        
        if (sumTotalTime(diffs,times,level) < limit) {
            return level;
        }

        while (min < max) {
            level = min + ((max - min) + 1) / 2;

            long totalTime = sumTotalTime(diffs, times, level);
            if (totalTime == limit || max == level || min == level) {
                break;
            } else if (totalTime > limit) {
                min = level;
            } else {
                max = level;
            }
        }

        return level;
    }
    
    public static long sumTotalTime(int[] diffs, int[] times, int level) {
        long totalTime = 0;

        for (int i = 0; i < diffs.length; i++) {
            int nowLevel = diffs[i];

            if (nowLevel <= level) {
                totalTime += times[i];
            } else {
                int repeat = nowLevel - level;

                totalTime += (times[i]+times[i-1]) * repeat + times[i];

            }
        }

        return totalTime;
    }
}