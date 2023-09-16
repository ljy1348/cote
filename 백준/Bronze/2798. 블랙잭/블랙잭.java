import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] first = br.readLine().split(" ");
		String[] card = br.readLine().split(" ");
		int[] cardNum = new int[card.length];
		for (int i = 0; i < card.length; i++) {
			cardNum[i] = Integer.valueOf(card[i]);
		}
		int n = Integer.valueOf(first[0]);
		int m = Integer.valueOf(first[1]);
		int sum = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int one = 0; one < n-2; one++) {
			for (int two = one+1; two < n-1; two++) {
				for (int three = two+1; three < n; three++) {
					sum = cardNum[one] + cardNum[two] + cardNum[three];
					if (sum <= m)result.add(sum);
				}
			}
		}
		Collections.sort(result);
		System.out.println(result.get(result.size()-1));

	}

}