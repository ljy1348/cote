import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;
        ArrayList<int[]>[][] arr = new ArrayList[r+1][c+1];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < r+1; i++) {
            for (int j = 0; j < c+1; j++) {
                arr[i][j] = new ArrayList<>();

            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            int[] temp = {x,y};
            int[] temp2 = {s,d,z};
            list.add(temp);
            arr[x][y].add(temp2);
        }
        for (int i = 1; i <= c; i++) {

        result += shark(i,list,arr,r,c);
        }
        System.out.println(result);

    }//main end
    static int shark(int p, List<int[]> list, ArrayList<int[]>[][] arr, int r, int c) {
        int size = list.size();
        int min = 105;
        int result = 0;
        int idx = 0;
        for (int i = 0; i < size; i++) {
            int[] minTemp = list.get(i);
            if (minTemp[1] == p && minTemp[0] < min) {idx = i; min = minTemp[0];}
        }
        if (min != 105) {
            list.remove(idx);
            result += arr[min][p].get(0)[2];
            arr[min][p].remove(0);
        }
        size = list.size();
        if (size < 1) return result;
        for (int i = 0; i < size; i++) {
            int x = list.get(0)[0];
            int y = list.get(0)[1];
            int x2 = x;
            int y2 = y;
            int[] temp = arr[x][y].get(0);
            int d = temp[1];
            int s = temp[0];
            int z = temp[2];
            // 상
            if (d == 1) {
                int distance = r-x+s;
                int cal = distance%(r-1);
                if ((distance/(r-1))%2 == 0) x = r-cal;
                else {x = 1 + cal; d = 2;}
            }
            else if (d == 2) {
                int distance = x-1+s;
                int cal = distance%(r-1);
                if ((distance/(r-1))%2 == 0) x = 1+cal;
                else {x = r-cal; d = 1;}
            }
            else if (d == 3) {
                int distance = y-1+s;
                int cal = distance%(c-1);
                if ((distance/(c-1))%2 == 0) y = 1+cal;
                else {y = c-cal; d = 4;}
            }
            else if (d == 4) {
                int distance = c-y+s;
                int cal = distance%(c-1);
                if ((distance/(c-1))%2 == 0) y = c-cal;
                else {y = 1+cal; d = 3;}
            }
            int[] temp2 = {s,d,z};
            arr[x][y].add(temp2);
            arr[x2][y2].remove(0);
            list.remove(0);
            int[] temp3 = {x,y};
            list.add(temp3);
        }

        for (int i = 0; i < list.size(); i++) {
            int[] arr4 = list.get(i);
            ArrayList<int[]> listTemp = arr[arr4[0]][arr4[1]];
            int size2 = listTemp.size();
            int tempIdx = 0;
            if (size2 > 1) {
                if (listTemp.get(tempIdx)[2] > listTemp.get(tempIdx+1)[2]) arr[arr4[0]][arr4[1]].remove(tempIdx+1);
                else arr[arr4[0]][arr4[1]].remove(tempIdx);
                size2--;
                list.remove(i);
                i--;
            }

        }
        return result;
    }
}