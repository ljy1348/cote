import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * packageName : backjoon
 * fileName : P11478
 * author : GGG
 * date : 2023-09-22
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-09-22         GGG          최초 생성
 */
public class Main {
    static public int arr (int n, String str) {
        if (n > str.length()) return 0;
        Set<String> set = new HashSet<>();
        int count = 0;
        String sub = "";
        for (int i = 0; i < n; i++) {
            sub = str.substring(i,str.length()-n+1+i);
            set.add(sub);
        }
            count += arr(n+1,str)+set.size();
            return count;

    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int result = arr(1,str);
        System.out.println(result);
    }
}