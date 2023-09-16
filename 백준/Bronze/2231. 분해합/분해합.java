import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		for (int i = 1; i < n; i++) {
			String num = String.valueOf(i);
			int sum = i;
			for (int j = 0; j < num.length(); j++) {
				sum += num.charAt(j)-48;
			}
			if (sum == n) {
                result = i;
                break;
            }
		}
		System.out.println(result);
	}
}