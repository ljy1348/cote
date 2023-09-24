import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        BigInteger bigInput = new BigInteger(input);
        bigInput = bigInput.add(new BigInteger("1"));
        input = bigInput.toString();
        if (input.length()<2) {System.out.println(input); return;}
        String str1 = "";
        String str2 = "";
        String result = "";
        int num = 0;
        if (input.length() % 2 == 0) {
            str1 = input.substring(0, input.length() / 2);
            str2 = input.substring(input.length()/2,input.length());
        } else {
            str1 = input.substring(0, input.length() / 2);
            str2 = input.substring(input.length()/2+1,input.length());
            num = Integer.parseInt(input.substring(input.length()/2,input.length()/2+1));
        }
        StringBuffer sb = new StringBuffer(str1);
        BigInteger big1 = new BigInteger(str1);
        BigInteger big2 = new BigInteger(str2);
        BigInteger big3 = new BigInteger(sb.reverse().toString());
        if (big3.compareTo(big2) == -1) {
            if (input.length()%2==0) {
                big1 = big1.add(new BigInteger("1"));
                str1 = big1.toString();
                sb = new StringBuffer(str1);
                str2 = sb.reverse().toString();
                System.out.println(str1+str2);
            } else {
                num++;
                if (num > 9) {
                    num = 0;
                big1 = big1.add(new BigInteger("1"));
                }
                str1 = big1.toString();
                sb = new StringBuffer(str1);
                str2 = sb.reverse().toString();
                System.out.println(str1+num+str2);
            }
        } else {
            if (input.length()%2==0) {
                str1 = big1.toString();
                sb = new StringBuffer(str1);
                str2 = sb.reverse().toString();
                System.out.println(str1+str2);
            } else {
                str1 = big1.toString();
                sb = new StringBuffer(str1);
                str2 = sb.reverse().toString();
                System.out.println(str1+num+str2);
            }
        }
    }
}