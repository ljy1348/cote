import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        while (n-- > 0) {
            int input = Integer.parseInt(br.readLine());



            if (input == 0) {


                if (list.size() > 0) {
                    //remove
                    sb.append(list.get(0)).append("\n");
                    remove(list);

                } else {
                    sb.append(0).append("\n");
                }
            } else {
                // add
                add(input, list);
            }
//            debug
//            for (int now : list) {
//                    sb.append(now).append(" ");
//                }
//                System.out.println(sb);
//                sb = new StringBuilder();

        }
        System.out.println(sb);
        br.close();

    }

    static void add(int input, List<Integer> list) {
        int index = list.size();
        list.add(input);
        int parentIndex = (index-1)/2;
        int parent = list.get(parentIndex);

        while (parent < input) {
            list.set(parentIndex, input);
            list.set(index, parent);
            index = parentIndex;
            parentIndex = (index-1)/2;
            parent = list.get(parentIndex);
        }

    }

    static void remove(List<Integer> list) {
        int last = list.get(list.size()-1);
        list.set(0, last);
        list.remove(list.size()-1);
        int index = 0;
        int child1 = index*2+1;
        int child2 = index*2+2;

        int childIndex;
        int child;

        if (child1 >= list.size()) {
            return;
        }
        else if (child2 >= list.size()) {
            childIndex = child1;
        } else {
            childIndex = list.get(child1) > list.get(child2) ? child1 : child2;
        }
        child = list.get(childIndex);

        while (child > last) {
            list.set(index, child);
            list.set(childIndex, last);

            index = childIndex;
            child1 = index*2+1;
            child2 = index*2+2;

            if (child1 >= list.size()) {
            return;
            }
            else if (child2 >= list.size()) {
                childIndex = child1;
            } else {
                childIndex = list.get(child1) > list.get(child2) ? child1 : child2;
            }
            child = list.get(childIndex);

        }
    }


}