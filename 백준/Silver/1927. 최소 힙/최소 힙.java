import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Integer> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        while (testcase-- > 0) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                if (list.size() > 0) {

                    sb.append(list.get(0)).append("\n");
                    list.set(0, list.get(list.size()-1));
                    list.remove(list.size()-1);

                    int index = 0;

                    while (list.size() > 1) {

                        int now = list.get(index);

                        int left = Integer.MAX_VALUE;
                        int right = Integer.MAX_VALUE;

                        if (index*2+1 < list.size()) {
                            left =  list.get(index*2 + 1);
                        }

                        if (index*2+2 < list.size()) {
                            right =  list.get(index*2 + 2);
                        }



                        if (left > right && now > right ) {
                            list.set(index, right);
                            list.set(index*2 + 2, now);
                            index = index*2 + 2;
                        } else if (left <= right && now > left) {
                            list.set(index, left);
                            list.set(index*2 + 1, now);
                            index = index*2 + 1;
                        } else {
                            break;
                        }

                    }


                } else {
                    sb.append(0).append("\n");
                }
            }
            else {

                if (list.size() == 0) {
                    list.add(input);
                } else {
                    int index = list.size();
                    list.add(input);
                    while(true) {
                        int pIndex = (index-1)/2;
                        int parent = list.get(pIndex);
                        if (input < parent) {
                            list.set(pIndex, input);
                            list.set(index, parent);
                        } else {
                            break;
                        }

                        index = pIndex;
                    }


                }

            }


        }

        System.out.println(sb.toString());
        br.close();
    }
}