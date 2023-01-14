import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge2 implements Comparable<Edge2> {
    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge2(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return distance;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    @Override
    public int compareTo(Edge2 o) {
        if (this.distance < o.distance) {
            return -1;
        }
        return 1;
    }
}

public class Main7 {

    public static int n, m;
    public static int[] parent = new int[100001];
    public static ArrayList<Edge2> edges = new ArrayList<>();
    public static int result = 0;

    public static int findParent(int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges.add(new Edge2(c, a, b));
        }

        Collections.sort(edges);
        int last = 0;   // 최소 신장 트리에 포함되는 간선 중에서 가장 비용이 큰 간선

        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();
            if (findParent(a) != findParent(b)) {
                unionParent(a,b);
                result += cost;
                last = cost;
            }
        }

        System.out.println(result - last);
    }
}
