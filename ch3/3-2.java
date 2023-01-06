import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int array [] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // 배열 정렬
        Arrays.sort(array);
        int first = array[n - 1];
        int second = array[n - 2];

        // 가장 큰 숫자가 더해지는 횟수
        int cnt = (m / (k + 1)) * k;
        cnt += (m % (k + 1));

        int result = 0;
        result += first * cnt;
        result += second * (m - cnt);

        System.out.println(result);
    }
}
