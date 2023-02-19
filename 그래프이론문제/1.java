import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {

    public static int n, m;
    public static int[] parent = new int[501];

    public static int findParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        if (x < y) parent[y] = x;
        else parent[x] = y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                if (x == 1) {
                    unionParent(i + 1, j + 1);
                }
            }
        }

        ArrayList<Integer> plan = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            plan.add(sc.nextInt());
        }

        boolean check = true;
        // 여행 계획에 속하는 모든 노드의 루트가 동일한지 확인
        for (int i = 0; i < m - 1; i++) {
            if (findParent(plan.get(i)) != findParent(plan.get(i + 1))) {
                check = false;
            }
        }

        if (check) System.out.println("YES");
        else System.out.println("NO");
    }
}
