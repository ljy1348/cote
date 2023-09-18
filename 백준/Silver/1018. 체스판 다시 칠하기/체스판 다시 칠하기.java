import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * packageName : backjoon
 * fileName : P1018
 * author : GGG
 * date : 2023-09-18
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-09-18         GGG          최초 생성
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nm = br.readLine();
        String[] cut = nm.split(" ");
        int n = Integer.valueOf(cut[0]);
        int m = Integer.valueOf(cut[1]);
        int countB = 0;
        int countW = 0;
        char test;
        int min = 999999;
        String[] input = new String[n];
        for (int i = 0; i < n; i++){
            input[i] = br.readLine();
        }
        for (int i = 0; i < m-7; i++) {
            for (int j = 0; j < n-7; j++) {
                for (int l = j; l < j+8; l++) {
                    for (int k = i; k < i + 8; k++) {
                        test = input[l].charAt(k);
//                         b로 시작
                        if ((l-j)%2 == 0) {
                            if (!((k-i)%2 == 1 || test == 'W')) {
//                            System.out.println(l+","+k);
                            countB++;
                            }
                            if (!((k-i)%2 == 0 || test == 'B')) {
                            countB++;
                            }
                        }
                        if ((l-j)%2 == 1) {
                            if (!((k-i)%2 == 0 || test == 'W')) {
                            countB++;
                            }
                            if (!((k-i)%2 == 1 || test == 'B')) {
                            countB++;
                            }
                            }
                        //W로 시작
                        if ((l-j)%2 == 1) {
                            if (!((k-i)%2 == 1 || test == 'W')) {
//                            System.out.println(l+","+k);
                                countW++;
                            }
                            if (!((k-i)%2 == 0 || test == 'B')) {
                                countW++;
                            }
                        }
                        if ((l-j)%2 == 0) {
                            if (!((k-i)%2 == 0 || test == 'W')) {
                                countW++;
                            }
                            if (!((k-i)%2 == 1 || test == 'B')) {
                                countW++;
                            }
                        }
                    }
                }
//                System.out.println("바둑판 ------"+countB+","+countW+" : "+i+","+j);
                if (countB < min) min = countB;
                if (countW < min) min = countW;
                countB = 0;
                countW = 0;
            }
        }
//        System.out.println(countB+","+countW);
        System.out.println(min);
    }
}