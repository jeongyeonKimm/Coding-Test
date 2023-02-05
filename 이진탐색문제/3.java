import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        Collections.sort(arr);

        int start = 1;  // 가능한 최소 거리(min gap)
        int end = arr.get(n - 1) - arr.get(0);  // 가능한 최대 거리(max gap)
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            // 첫째 집에는 무조건 공유기를 설치한다고 가정
            int value = arr.get(0);
            int cnt = 1;
            // 현재의 mid 값을 이용해 공유기를 설치하기
            for (int i = 1; i < n; i++) {
                if (arr.get(i) >= value + mid) {
                    value = arr.get(i);
                    cnt += 1;
                }
            }
            // C개 이상의 공유기를 설치할 수 있는 경우, 거리를 증가시키기
            if (cnt >= c) {
                start = mid + 1;
                result = mid; // 최적의 결과를 저장
            }
            // C개 이상의 공유기를 설치할 수 없는 경우, 거리를 감소시키기
            else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
