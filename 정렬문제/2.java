import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Integer> houses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            houses.add(sc.nextInt());
        }

        Collections.sort(houses);

        System.out.println(houses.get((n - 1) / 2));
    }
}
