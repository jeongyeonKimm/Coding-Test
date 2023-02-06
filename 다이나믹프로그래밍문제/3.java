import java.util.Scanner;

public class Main3 {

    public static int n;
    public static int[] t = new int[15];
    public static int[] p = new int[15];
    public static int[] dp = new int[16];
    public static int  maxValue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for (int i = n - 1; i >= 0; i--) {
            int time = t[i] + i;
            if (time <= n) {
                dp[i] = Math.max(p[i] + dp[time], maxValue);
                maxValue = dp[i];
            }
            else dp[i] = maxValue;
        }

        System.out.println(maxValue);
    }
}
