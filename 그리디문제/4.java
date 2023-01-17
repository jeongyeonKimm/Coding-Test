import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main4 {

    public static int n;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        Collections.sort(arr);

        int target = 1;
        for (int i = 0; i < n; i++) {
            if (target < arr.get(i)) break;
            target += arr.get(i);
        }

        System.out.println(target);
    }
}
