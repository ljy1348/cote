import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int pokemonCount = Integer.parseInt(st.nextToken());
        int questionCount = Integer.parseInt(st.nextToken());

        StringBuilder sb  = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        while (list.size() < pokemonCount) {
            String pokemon = br.readLine();
            list.add(pokemon);
            map.put(pokemon, list.size());
        }

        while (--questionCount >= 0) {
            String question = br.readLine();

            try {
                int no = Integer.parseInt(question);
                sb.append(list.get(no-1)).append("\n");

            } catch (NumberFormatException e) {
                sb.append(map.get(question)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }


}