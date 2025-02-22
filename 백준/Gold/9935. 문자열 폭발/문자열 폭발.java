import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack<>();
        char trigger = bomb.charAt(bomb.length()-1);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (stack.size() >= bomb.length()-1 && c == trigger) {
                for (int j = bomb.length()-2; j >= 0; j--) {
                    if (stack.isEmpty()) {
                        stack.push(c);
                        break;
                    }
                    char c2 = stack.peek();
                    if (c2 != bomb.charAt(j)) {
                        for (int k = j+1; k < bomb.length(); k++) {
                            stack.push(bomb.charAt(k));
                        }
                        break;
                    } else {
                        stack.pop();
                    }
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        if (!stack.isEmpty()) {
            Stack<Character> temp = new Stack<>();
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            while (!temp.isEmpty()) {
                sb.append(temp.pop());
            }
        } else {
            sb.append("FRULA");
        }
        System.out.println(sb);

    }

}