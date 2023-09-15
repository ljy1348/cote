import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Integer.parseInt(br.readLine());
		String ai = br.readLine();
		String bc = br.readLine();
		long count = n;
		String[] a = ai.split(" ");
		String[] b = bc.split(" ");
		for (int i = 0; i < n; i++) {
			int cal = Integer.valueOf(a[i]) - Integer.valueOf(b[0]);
			if (cal > 0) {
				if (cal % Integer.valueOf(b[1]) == 0) {
					count += cal/Integer.valueOf(b[1]);
				} else {
					count += cal/Integer.valueOf(b[1])+1;
				}
			}
		}
		System.out.println(count);
		
	}

}