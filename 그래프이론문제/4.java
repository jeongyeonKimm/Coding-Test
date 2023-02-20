import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge2 implements Comparable<Edge2> {
    private int x;
    private int y;
    private int distance;

    public Edge2(int x, int y, int distance) {
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
    public int compareTo(Edge2 other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

class Position implements Comparable<Position> {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Position other) {
        if (this.x == other.x) {
            return Integer.compare(this.y, other.y);
        }
        return Integer.compare(this.x, other.x);
    }
}

public class Main4 {

    public static int n;
    public static int[] parent = new int[100001];
    public static ArrayList<Edge2> edges = new ArrayList<>();

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

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        ArrayList<Position> xList = new ArrayList<>();
        ArrayList<Position> yList = new ArrayList<>();
        ArrayList<Position> zList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            xList.add(new Position(x, i));
            yList.add(new Position(y, i));
            zList.add(new Position(z, i));
        }

        Collections.sort(xList);
        Collections.sort(yList);
        Collections.sort(zList);

        for (int i = 0; i < n - 1; i++) {
            edges.add(new Edge2(xList.get(i).getY(), xList.get(i + 1).getY(), xList.get(i + 1).getX() - xList.get(i).getX()));
            edges.add(new Edge2(yList.get(i).getY(), yList.get(i + 1).getY(), yList.get(i + 1).getX() - yList.get(i).getX()));
            edges.add(new Edge2(zList.get(i).getY(), zList.get(i + 1).getY(), zList.get(i + 1).getX() - zList.get(i).getX()));
        }

        Collections.sort(edges);

        int result = 0;
        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int x = edges.get(i).getX();
            int y = edges.get(i).getY();
            if (findParent(x) != findParent(y)) {
                unionParent(x, y);
                result += cost;
            }
        }

        System.out.println(result);
    }
}
