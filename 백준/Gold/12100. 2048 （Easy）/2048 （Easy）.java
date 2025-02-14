import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void boardMove(int[][] board, int 방향) {
        // 위로 이동 : 위에서 아래로 이동 하면서 위로 끌어올림, +
        // 아래로 이동 : 아래에서 위로 이동 하면서 아래로 내림  -
        // 왼쪽으로 이동 : 왼쪽에서 오른쪽으로 이동 하면서 왼쪽으로 이동시킴 +
        // 오른쪽으로 이동 : 오른쪽에서 왼쪽으로 이동하면서 오른쪽으로 이동 시킴 -
        int n = board.length;
        int[][] adds = {{-1,0},{1,0},{0,-1},{0,1}};
        int[][] moves = {{0,0, 1, 1},{n-1, 0, -1, 1},{0, 0, 1, 1},{0, n-1, 1, -1}};
        boolean[][] visit = new boolean[n][n];

        int[] add = adds[방향];
        int[] move = moves[방향];
        int i = move[0];
        int j = move[1];
        while (i < n && i >= 0) {
            while (j < n && j >= 0) {
                int now = board[i][j];
                if (now > 0) {
                    int x = i+add[0];
                    int y = j+add[1];
                    while (x < n && x >= 0 && y < n && y >= 0) {
                        if (visit[x][y]) {
                            break;
                        }
                        int next = board[x][y];
                        if (next == 0) {
                            board[x-add[0]][y-add[1]] = 0;
                            board[x][y] = now;
                        } else if (next == now) {
                            board[x-add[0]][y-add[1]] = 0;
                            board[x][y] = now*2;
                            visit[x][y] = true;
                        } else {
                            break;
                        }
                        x += add[0];
                        y += add[1];
                    }
                }


                j += move[3];
            }
            i += move[2];
            j = move[1];
        }






    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int max = Integer.MIN_VALUE;

        int[][] testBoard = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    testBoard[j][k] = board[j][k];
                }
            }

        boardMove(testBoard, 0);
        boardMove(testBoard, 0);
        boardMove(testBoard, 0);
        boardMove(testBoard, 2);
        boardMove(testBoard, 2);
        for (int i = 0; i < 4; i++) {
            int[][] newBoard = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    newBoard[j][k] = board[j][k];
                }
            }
            boardMove(newBoard, i);

            for (int j = 0; j < 4; j++) {
                int[][] newBoard1 = new int[n][n];
            for (int a1 = 0; a1 < n; a1++) {
                for (int ab = 0; ab < n; ab++) {
                    newBoard1[a1][ab] = newBoard[a1][ab];
                }
            }
                boardMove(newBoard1, j);
                for (int k = 0; k < 4; k++) {
                int[][] newBoard2 = new int[n][n];
            for (int a1 = 0; a1 < n; a1++) {
                for (int ab = 0; ab < n; ab++) {
                    newBoard2[a1][ab] = newBoard1[a1][ab];
                }
            }
                    boardMove(newBoard2, k);
                    for (int l = 0; l < 4; l++) {
                            int[][] newBoard3 = new int[n][n];
            for (int a1 = 0; a1 < n; a1++) {
                for (int ab = 0; ab < n; ab++) {
                    newBoard3[a1][ab] = newBoard2[a1][ab];
                }
            }

                        boardMove(newBoard3, l);
                        for (int m = 0; m < 4; m++) {
                                int[][] newBoard4 = new int[n][n];
            for (int a1 = 0; a1 < n; a1++) {
                for (int ab = 0; ab < n; ab++) {
                    newBoard4[a1][ab] = newBoard3[a1][ab];
                }
            }
                            boardMove(newBoard4, m);
                            int aa = 0;
                            for (int a = 0; a < n; a++) {
                                for (int b = 0; b < n; b++) {
                                    max = Math.max(max, newBoard4[a][b]);
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(max);



    }
}