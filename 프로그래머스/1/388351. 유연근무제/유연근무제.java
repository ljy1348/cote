class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            int nowDay = startday;
            int MaxSchedule = getMaxSchedules(schedules[i]);
            boolean succ = true;
            
            for (int log : timelogs[i]) {
                
                if (nowDay < 6 &&log > MaxSchedule) {
                    succ = false;
                    break;
                }
                
                nowDay++;
                if (nowDay > 7) nowDay -= 7;
                
            }
            
            if (succ) {
                answer++;
            }
            
        }
        
        return answer;
    }
    
    public int getMaxSchedules(int schedules) {
        int hour = (int) schedules/100;
        int minute = schedules%100;
        int addMinute = minute + 10;
        
        if (addMinute > 59) {
            hour += 1;
            addMinute -= 60;
        }
        
        return (hour*100) + addMinute;
    }
}