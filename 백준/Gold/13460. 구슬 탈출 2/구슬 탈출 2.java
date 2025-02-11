import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static int[] calc(char[][] board, int[] coordinate, int move) {
        int distance = 0;
        int out = 0;
        while (true) {
            char ch;
            switch(move) {
                case 1:
                    ch = board[coordinate[0]-1][coordinate[1]];
                    break;
                case 2:
                    ch = board[coordinate[0]+1][coordinate[1]];
                    break;
                case 3:
                    ch = board[coordinate[0]][coordinate[1]-1];
                    break;
                case 4:
                    ch = board[coordinate[0]][coordinate[1]+1];
                    break;
                default:
                    ch = '#';
            }

            if (ch == 'O') {
                out = 1;
                break;
            } else if (ch == '.') {
                distance++;
                switch(move) {
                case 1:
                    coordinate[0]--;
                    break;
                case 2:
                    coordinate[0]++;
                    break;
                case 3:
                    coordinate[1]--;
                    break;
                case 4:
                    coordinate[1]++;
                    break;
            }
            } else {
                break;
            }
        }
        return new int[] { coordinate[0], coordinate[1], distance , out};
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] originBoard = new char[n][m];

        Stack<int[][]> stack  = new Stack<>();
        int[] redStart = new int[2];
        int[] blueStart = new int[2];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char ch = line.charAt(j);

                if (ch == 'R') {
                    redStart[0] = i;
                    redStart[1] = j;
                    ch = '.';
                } else if (ch == 'B') {
                    blueStart[0] = i;
                    blueStart[1] = j;
                    ch = '.';
                }

                originBoard[i][j] = ch;

            }
        }
        int[][] start = {redStart, blueStart, {0}};
        stack.push(start);
        int count = Integer.MAX_VALUE;
        while (!stack.empty()) {
            int[][] current = stack.pop();
            if (current[2][0] >= 10) {
                continue;
            }
            char[][] board = new char[n][m];
            for (int i = 1; i < 5; i++) {
                int[] reddot = {current[0][0], current[0][1]};
                int[] bluedot = {current[1][0], current[1][1]};
                int depth = current[2][0];
                for (int a = 0; a < n; a++) {
                    for (int j = 0; j < m; j++) {
                        board[a][j] = originBoard[a][j];
                    }
                }
                    board[reddot[0]][reddot[1]] = 'R';
                    board[bluedot[0]][bluedot[1]] = 'B';
                // 1 = 위, 2 = 아래, 3 = 왼, 4 = 오

                if (i == 1) {

                    if (reddot[0] < bluedot[0]) {
                        reddot = calc(board, reddot, i);
                        board[current[0][0]][current[0][1]] = '.';
                        if (reddot[3] == 0){
                        board[reddot[0]][reddot[1]] = 'R';
                        }
                        bluedot = calc(board, bluedot, i);
                        if (bluedot[3] == 0 && reddot[3] == 1) {
                            count = Math.min(depth+1, count);
                            break;
                        } else if (bluedot[3] == 0 && (reddot[2] > 0||bluedot[2] > 0)) {
                            int[][] temp = {reddot, bluedot, {depth+1}};
                            stack.push(temp);
                        }
                    } else {
                        bluedot = calc(board, bluedot, i);
                        board[current[1][0]][current[1][1]] = '.';
                        board[bluedot[0]][bluedot[1]] = 'B';
                        reddot = calc(board, reddot, i);
                        if (bluedot[3] == 0 && reddot[3] == 1) {
                            count = Math.min(depth+1, count);
                            break;
                        } else if (bluedot[3] == 0 && (reddot[2] > 0||bluedot[2] > 0)) {
                            int[][] temp = {reddot, bluedot, {depth+1}};
                            stack.push(temp);
                        }

                    }
                } else if (i == 2) {
                    if (reddot[0] > bluedot[0]) {
                        reddot = calc(board, reddot, i);
                        board[current[0][0]][current[0][1]] = '.';
                        if (reddot[3] == 0){
                        board[reddot[0]][reddot[1]] = 'R';
                        }
                        bluedot = calc(board, bluedot, i);
                        if (bluedot[3] == 0 && reddot[3] == 1) {
                            count = Math.min(depth+1, count);
                            break;
                        } else if (bluedot[3] == 0 && (reddot[2] > 0||bluedot[2] > 0)) {
                            int[][] temp = {reddot, bluedot, {depth+1}};
                            stack.push(temp);
                        }
                    } else {
                        bluedot = calc(board, bluedot, i);
                        board[current[1][0]][current[1][1]] = '.';
                        board[bluedot[0]][bluedot[1]] = 'B';
                        reddot = calc(board, reddot, i);
                        if (bluedot[3] == 0 && reddot[3] == 1) {
                            count = Math.min(depth+1, count);
                            break;
                        } else if (bluedot[3] == 0 && (reddot[2] > 0||bluedot[2] > 0)) {
                            int[][] temp = {reddot, bluedot, {depth+1}};
                            stack.push(temp);
                        }
                    }
                } else if (i == 3) {
                    if (reddot[1] < bluedot[1]) {
                        reddot = calc(board, reddot, i);
                        board[current[0][0]][current[0][1]] = '.';
                        if (reddot[3] == 0){
                        board[reddot[0]][reddot[1]] = 'R';
                        }
                        bluedot = calc(board, bluedot, i);
                        if (bluedot[3] == 0 && reddot[3] == 1) {
                            count = Math.min(depth+1, count);
                            break;
                        } else if (bluedot[3] == 0 && (reddot[2] > 0||bluedot[2] > 0)) {
                            int[][] temp = {reddot, bluedot, {depth+1}};
                            stack.push(temp);
                        }
                    } else {
                        bluedot = calc(board, bluedot, i);
                        board[current[1][0]][current[1][1]] = '.';
                        board[bluedot[0]][bluedot[1]] = 'B';
                        reddot = calc(board, reddot, i);
                        if (bluedot[3] == 0 && reddot[3] == 1) {
                            count = Math.min(depth+1, count);
                            break;
                        } else if (bluedot[3] == 0 && (reddot[2] > 0||bluedot[2] > 0)) {
                            int[][] temp = {reddot, bluedot, {depth+1}};
                            stack.push(temp);
                        }
                    }
                } else if (i == 4) {
                    if (reddot[1] > bluedot[1]) {
                        reddot = calc(board, reddot, i);
                        board[current[0][0]][current[0][1]] = '.';
                        if (reddot[3] == 0){
                        board[reddot[0]][reddot[1]] = 'R';
                        }
                        bluedot = calc(board, bluedot, i);
                        if (bluedot[3] == 0 && reddot[3] == 1) {
                            count = Math.min(depth+1, count);
                            break;
                        } else if (bluedot[3] == 0 && (reddot[2] > 0||bluedot[2] > 0)) {
                            int[][] temp = {reddot, bluedot, {depth+1}};
                            stack.push(temp);
                        }
                    } else {
                        bluedot = calc(board, bluedot, i);
                        board[current[1][0]][current[1][1]] = '.';
                        board[bluedot[0]][bluedot[1]] = 'B';
                        reddot = calc(board, reddot, i);
                        if (bluedot[3] == 0 && reddot[3] == 1) {
                            count = Math.min(depth+1, count);
                            break;
                        } else if (bluedot[3] == 0 && (reddot[2] > 0||bluedot[2] > 0)) {
                            int[][] temp = {reddot, bluedot, {depth+1}};
                            stack.push(temp);
                        }
                    }
                }



            }




        }

        if (count == Integer.MAX_VALUE) {
            count = -1;
        }
        System.out.println(count);

    }
}