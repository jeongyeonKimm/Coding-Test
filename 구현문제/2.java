import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {

    public static String str;
    public static int sum = 0;
    public static ArrayList<Character> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        str = sc.next();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                arr.add(str.charAt(i));
            }
            else {
                sum += str.charAt(i) - '0';
            }
        }

        Collections.sort(arr);

        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i));
        }
        System.out.print(sum);
    }
}
