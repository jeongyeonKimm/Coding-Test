import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;

        int array [][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            int min = 10001;
            for (int j = 0; j < m; j++) {
                array[i][j] = sc.nextInt();
                // 각 행의 가장 작은 수 찾기
                min = Math.min(min, array[i][j]);
            }
            // 가장 작은 수들 중 가장 큰 수 찾기
            result = Math.max(min, result);
        }

        System.out.println(result);
    }
}
