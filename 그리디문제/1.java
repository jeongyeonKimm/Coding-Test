import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main1 {

    public static int n;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        Collections.sort(arr);

        int result = 0; // 총 그룹의 수
        int cnt = 0;    // 현재 그룹에 포함된 사람의 수

        for (int i = 0; i < n; i++) {
            cnt += 1;
            if (cnt >= arr.get(i)) {
                result += 1;
                cnt = 0;
            }
        }

        System.out.println(result);
    }
}
