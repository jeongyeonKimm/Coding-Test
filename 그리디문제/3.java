import java.util.Scanner;

public class Main3 {

    public static int cnt0 = 0;
    public static int cnt1 = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        if (s.charAt(0) == '1') {
            cnt0 += 1;
        }
        else {
            cnt1 += 1;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                if (s.charAt(i + 1) == '1') {
                    cnt0 += 1;
                }
                else {
                    cnt1 += 1;
                }
            }
        }

        System.out.println(Math.min(cnt0, cnt1));
    }
}
