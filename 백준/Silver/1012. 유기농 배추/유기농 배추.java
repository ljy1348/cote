import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * packageName : backjoon
 * fileName : P1012
 * author : GGG
 * date : 2023-09-27
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-09-27         GGG          최초 생성
 */
public class Main {
    public static void main(String[] args) throws IOException {
//        int[][] land = {{1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0, 0, 0}
//                , {0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 0, 1, 1, 1}, {0, 0, 0, 0, 1, 0, 0, 1, 1, 1}};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        String result = "";
        for (int z = 0; z < t; z++) {


            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] land = new int[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                land[y][x] = 1;
            }


            int count = 0;
            Stack<int[]> stack = new Stack<>();
            ArrayList<int[]>[][] landList = new ArrayList[land.length][land[0].length];
//        연결된 노드 확인하기
            for (int i = 0; i < land.length; i++) {
                for (int j = 0; j < land[0].length; j++) {
//                if (land[i][j] == 1) {
                    landList[i][j] = new ArrayList<int[]>();
                    if (i > 0) {
                        if (land[i - 1][j] == 1) {
                            int[] temp = {i - 1, j};
                            landList[i][j].add(temp);
                        }
                    }
                    if (i < land.length - 1) {
                        if (land[i + 1][j] == 1) {
                            int[] temp = {i + 1, j};
                            landList[i][j].add(temp);
                        }
                    }
                    if (j < land[0].length - 1) {
                        if (land[i][j + 1] == 1) {
                            int[] temp = {i, j + 1};
                            landList[i][j].add(temp);
                        }
                    }
                    if (j > 0) {
                        if (land[i][j - 1] == 1) {
                            int[] temp = {i, j - 1};
                            landList[i][j].add(temp);
                        }
                    }
//                }
                }
            }
            boolean[][] landVisit = new boolean[land.length][land[0].length]; // 노드 방문 확인 배열

            /*
             *       dfs 실행 (
             *       1. landvisit이 false인 영역에서 값이 1인 위치 찾기 + 방문 true
             *       2. landList에서 연결된 노드가 존재한다면 Stack에 연결된 노드 넣기
             *       3. 연결된 노드의 방문여부를 확인 한 뒤 방문하지 않았으면 연결된 노드로 이동 이후 방문한 노드 true
             *       3. Stack의 size()가 0이 될 때까지 반복
             * )
             * */
            for (int i = 0; i < landList.length; i++) {
                for (int j = 0; j < landList[0].length; j++) {
                    if (landVisit[i][j] == false && land[i][j] == 1) {
                        dfs(landVisit, landList, i, j, stack);
                        count++;
                    }
                }
            }
            result += count+" ";
        }
        String[] answer = result.split(" ");
        for (String s : answer) {
            System.out.println(s);
        }
    }
//        디버깅 영역
//        for (int i = 0; i < landList.length; i++) {
//            for (int j = 0; j < landList[0].length; j++) {
//                System.out.println(landList[i][j].size());
//            }
//        }

    static void dfs(boolean[][] landVisit,ArrayList<int[]>[][] landList, int i, int j,Stack<int[]> stack) {
        landVisit[i][j] = true;
        if (landList[i][j].size() > 0) {
            for (int k = 0; k < landList[i][j].size(); k++) {
                int[] temp = landList[i][j].get(k);
                if (landVisit[temp[0]][temp[1]] == false) stack.push(temp);
            }
        if (stack.size() == 0) {return;}
            int[] temp = stack.pop();
            dfs(landVisit,landList,temp[0],temp[1],stack);
        }
    }

}