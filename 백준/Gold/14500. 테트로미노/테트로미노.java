import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * packageName : backjoon
 * fileName : P14500
 * author : GGG
 * date : 2023-09-26
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-09-26         GGG          최초 생성
 */
public class Main {
    public static int cal(int[][] paper,int[][] tetromino, int y, int x) {
        int result = 0;
        if (y+tetromino.length>paper.length || x+tetromino[0].length > paper[0].length) return 0;
        else {
            for (int i = y; i < y+tetromino.length; i++) {
                for (int j = x; j < x+tetromino[0].length; j++) {
                    if (tetromino[i-y][j-x] == 1)result += paper[i][j];
                }
            }
        }
        return result;
    }
    public static int line(int[][] paper, int y, int x) {
        int[][] tetromino = {{1,1,1,1}};
        int result = 0;
        int max = 0;
        // 처음 모양에서의 계산
        result = cal(paper,tetromino,y,x);
        max = result;
        result = 0;
        // 테트로미노 90도 회전
        tetromino = turn(tetromino);
        result = result = cal(paper,tetromino,y,x);
        // max 연산
        max = Math.max(max,result);
        return max;
    }

    public static int tetroL(int[][] paper, int y, int x) {
        int[][] tetromino = {{1,0},{1,0},{1,1}};
        int result = 0;
        int max = 0;
        result = cal(paper,tetromino,y,x);
        max = result;
        result = 0;
        // 테트로미노 90도 회전
        tetromino = turn(tetromino);
        result = cal(paper,tetromino,y,x);
        max = Math.max(max,result);
        result = 0;

        tetromino = turn(tetromino);
        result = cal(paper,tetromino,y,x);
        max = Math.max(max,result);
        result = 0;

        tetromino = turn(tetromino);
        result = cal(paper,tetromino,y,x);
        max = Math.max(max,result);
        result = 0;

        tetromino = mirrored(tetromino);
        result = cal(paper,tetromino,y,x);
        max = Math.max(max,result);
        result = 0;

        tetromino = turn(tetromino);
        result = cal(paper,tetromino,y,x);
        max = Math.max(max,result);
        result = 0;

        tetromino = turn(tetromino);
        result = cal(paper,tetromino,y,x);
        max = Math.max(max,result);
        result = 0;

        tetromino = turn(tetromino);
        result = cal(paper,tetromino,y,x);
        max = Math.max(max,result);
        result = 0;


        return max;
    }

    public static int square(int[][] paper, int y, int x) {
        int[][] tetromino = {{1, 1}, {1, 1}};
        int max = 0;
        max = cal(paper,tetromino,y,x);
        return max;
    }

    public static int tetra_t(int[][] paper, int y, int x) {
        int[][] tetromino = {{1,1,1}, {0, 1,0}};
        int result = 0;
        int max = 0;
        max = cal(paper,tetromino,y,x);
        tetromino = turn(tetromino);
        result = cal(paper,tetromino,y,x);
        max = Math.max(max,result);
        tetromino = turn(tetromino);
        result = cal(paper,tetromino,y,x);
        max = Math.max(max,result);
        tetromino = turn(tetromino);
        result = cal(paper,tetromino,y,x);
        max = Math.max(max,result);
        return max;
    }
    public static int tetra_z(int[][] paper, int y, int x) {
        int[][] tetromino = {{0,1,1}, {1, 1,0}};
        int result = 0;
        int max = 0;
        max = cal(paper,tetromino,y,x);
        tetromino = turn(tetromino);
        result = cal(paper,tetromino,y,x);
        max = Math.max(max,result);
        tetromino = mirrored(tetromino);
        result = cal(paper,tetromino,y,x);
        max = Math.max(max,result);
        tetromino = turn(tetromino);
        result = cal(paper,tetromino,y,x);
        max = Math.max(max,result);
        return max;
    }

    // 90도 회전시키기
    public static int[][] turn (int[][]tetromino) {
        int[][]result = new int[tetromino[0].length][tetromino.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j<result[0].length; j++) {
                result[i][result[0].length-1-j] = tetromino[j][i];
            }
        }
        return result;
    }

    // 좌우 반전 시키기
    public static int[][] mirrored (int[][]tetromino) {
        int[][] result = new int[tetromino.length][tetromino[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = tetromino[i][tetromino[0].length-1-j];
            }
        }
        
        return result;
                
    }

    public static void main(String[] args)throws IOException {
//        int[][]paper = {{1,2,3,4,5},{5,4,3,2,1},{2,3,4,5,6},{6,5,4,3,2},{1,2,1,2,1}};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] paper = new int[n][m];
        for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i < paper.length; i++) {
            for (int j = 0; j <paper[0].length; j++) {
                max = Math.max(max,line(paper,i,j));
                max = Math.max(max,square(paper,i,j));
                max = Math.max(max,tetra_t(paper,i,j));
                max = Math.max(max,tetra_z(paper,i,j));
                max = Math.max(max,tetroL(paper,i,j));
            }
        }
        System.out.println(max);
    }
}