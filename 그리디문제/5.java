import java.util.Scanner;

public class Main5 {

    public static int n, m;
    public static int[] arr = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[x] += 1;
        }

        int result = 0;

        for (int i = 1; i <= m; i++) {
            n -= arr[i];    // 무게가 i인 볼링공의 개수(A가 선택할 수 있는 공의 개수) 제외
            result += arr[i] * n;   // B가 선택하는 경우의 수와 곱하기
        }

        System.out.println(result);
    }
}
