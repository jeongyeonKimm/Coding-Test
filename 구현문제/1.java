import java.util.Scanner;

public class Main1 {

    public static int sum1 = 0;
    public static int sum2 = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        for (int i = 0; i < str.length() / 2; i++) {
            sum1 += str.charAt(i) - '0';
        }

        for (int i = str.length() / 2; i < str.length(); i++) {
            sum2 += str.charAt(i) - '0';
        }

        if (sum1 == sum2) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}
