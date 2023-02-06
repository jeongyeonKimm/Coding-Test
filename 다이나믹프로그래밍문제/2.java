import java.util.Scanner;

public class Main2 {

    public static int n;
    public static int[][] arr = new int[500][500];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 다이나믹 프로그래밍으로 2번째 줄부터 내려가면서 확인
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int upLeft, up;
                // 왼쪽 위에서 내려오는 경우
                if (j == 0) upLeft = 0;
                else upLeft = arr[i - 1][j - 1];
                // 바로 위에서 내려오는 경우
                if (j == i) up = 0;
                else up = arr[i - 1][j];
                arr[i][j] += Math.max(upLeft, up);
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, arr[n - 1][i]);
        }
        System.out.println(result);
    }
}
