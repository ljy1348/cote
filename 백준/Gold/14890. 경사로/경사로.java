import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        // 행
        for (int i = 0; i < n; i++) {
            int now = board[i][0];
            int linkCount = 1;
            boolean left = false;
            boolean load = true;
            String log = "";
            for (int j = 1; j < n; j++) {
                log += linkCount + " ";
                if (now - board[i][j] >= 2 || now - board[i][j] <= -2) {
                    left = false;
                    load = false;
                    break;
                } else if (now == board[i][j] + 1) {
                    if (left && linkCount < l) {
                        break;
                    }
                    left = true;
                    linkCount = 0;
                } else if (now == board[i][j] - 1) {
                    if (left) {
                        if (linkCount >= l) {
                            linkCount -= l;
                            left = false;
                        } else {
                            left = false;
                            load = false;
                            break;
                        }
                    }
                    if (linkCount >= l) {
                        linkCount = 0;
                    } else {
                        load = false;
                        break;
                    }
                }
                now = board[i][j];
                linkCount++;
            }
            if (left) {
                if (linkCount >= l) {
                    load = true;
                } else {
                    load = false;
                }
            }
            if (load) {
                count++;
            }
        }

        // 열
        for (int i = 0; i < n; i++) {
            int now = board[0][i];
            int linkCount = 1;
            boolean left = false;
            boolean load = true;
            String log = "";
            for (int j = 1; j < n; j++) {
                log += linkCount + " ";
                if (now - board[j][i] >= 2 || now - board[j][i] <= -2) {
                    left = false;
                    load = false;
                    break;
                } else if (now == board[j][i] + 1) {
                    if (left) {
                        if (linkCount < l) {
                            load = false;
                            break;
                        }
                    }
                    left = true;
                    linkCount = 0;
                } else if (now == board[j][i] - 1) {
                    if (left) {
                        if (linkCount >= l) {
                            linkCount -= l;
                            left = false;
                        } else {
                            left = false;
                            load = false;
                            break;
                        }
                    }
                    if (linkCount >= l) {
                        linkCount = 0;
                    } else {
                        load = false;
                        break;
                    }
                }
                now = board[j][i];
                linkCount++;
            }
            if (left) {
                if (linkCount >= l) {
                    load = true;
                } else {
                    load = false;
                }
            }
            if (load) {
                count++;
            }
        }
        System.out.println(count);
    }

}