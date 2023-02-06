import java.util.Scanner;

public class Main1 {

    public static int t, n, m;
    public static int[][] arr = new int[20][20];
    public static int[][] dp = new int[20][20];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }
            // 다이나믹 프로그래밍을 위한 2차원 DP 테이블 초기화
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    dp[j][k] = arr[j][k];
                }
            }
            // 다이나믹 프로그래밍 진행
            for (int k = 1; k < m; k++) {
                for (int j = 0; j < n; j++) {
                    int leftUp, leftDown, left;
                    // 왼쪽 위에서 오는 경우
                    if (j == 0) leftUp = 0;
                    else leftUp = dp[j - 1][k - 1];
                    // 왼쪽 아래에서 오는 경우
                    if (j == n - 1) leftDown = n - 1;
                    else leftDown = dp[j + 1][k - 1];
                    // 왼쪽에서 오는 경우
                    left = dp[j][k - 1];
                    dp[j][k] += Math.max(leftUp, Math.max(leftDown, left));
                }
            }
            int result = 0;
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dp[j][m - 1]);
            }
            System.out.println(result);
        }
    }
}
