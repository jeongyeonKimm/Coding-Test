import java.util.PriorityQueue;
import java.util.Scanner;

public class Main4 {

    public static int n, result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextInt());
        }

        while (pq.size() != 1) {
            int one = pq.poll();
            int two = pq.poll();
            int sum = one + two;
            result += sum;
            pq.offer(sum);
        }

        System.out.println(result);
    }
}
