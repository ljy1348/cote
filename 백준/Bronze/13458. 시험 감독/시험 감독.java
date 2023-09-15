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
		int main = Integer.valueOf(b[0]);
		int sub = Integer.valueOf(b[1]);
		for (int i = 0; i < n; i++) {
			int cal = Integer.valueOf(a[i]) - main;
			if (cal > 0) {
				if (cal % sub == 0) {
					count += cal/sub;
				} else {
					count += cal/sub+1;
				}
			}
		}
		System.out.println(count);
		
	}

}