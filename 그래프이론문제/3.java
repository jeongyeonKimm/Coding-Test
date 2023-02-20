import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    private int x;
    private int y;
    private int distance;

    public Edge(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Edge other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class Main3 {

    public static int n, m;
    public static int[] parent = new int[200001];
    public static ArrayList<Edge> edges = new ArrayList<>();

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

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            edges.add(new Edge(x, y, z));
        }

        Collections.sort(edges);

        int total = 0;
        int result = 0;
        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int x = edges.get(i).getX();
            int y = edges.get(i).getY();
            total += cost;
            if (findParent(x) != findParent(y)) {
                unionParent(x, y);
                result += cost;
            }
        }

        System.out.println(total - result);
    }
}
