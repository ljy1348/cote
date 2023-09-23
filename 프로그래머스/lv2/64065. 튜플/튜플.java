import java.util.*;
class Solution {
    public int[] solution(String s) {
        String[] result = s.split("\\,\\{");
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        Map<Integer,String> map = new HashMap<>();
        String str = "";
        String str2 = "2";
        int leng = 1;
        
        for (int i = 0; i < result.length; i++) {
            str = result[i].replaceAll("[{}]","");
            String[] strTemp = str.split(",");
            map.put(strTemp.length, str);
        }
        for (int i = 1; i <= result.length; i++) {
            String[] strTemp = map.get(i).split(",");
            for (int j = 0; j < i; j++) {
                set.add(Integer.parseInt(strTemp[j]));
            }
        }
        int[] answer = new int[set.size()];
        Iterator iter = set.iterator();
        int it = 0;
		while(iter.hasNext()){
			answer[it] = Integer.parseInt(iter.next().toString());
            it++;
	}
        
        return answer;
    }
}