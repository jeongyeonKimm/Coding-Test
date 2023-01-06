import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while (true) {
            int target = (n / k) * k;   // n보다 작고 k로 나누어 떨어지는 수
            result += (n - target); // 1을 빼는 횟수
            n = target;
            if (n < k) break;
            n /= k;
            result += 1;    // k로 나누는 횟수
        }

        result += (n - 1);  // n이 k보다 작아 k로 더이상 나누어 떨어질 수 없을 때 남은 수에 대해 1씩 빼기
        System.out.println(result);
    }
}
