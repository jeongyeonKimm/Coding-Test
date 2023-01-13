import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node3 implements Comparable<Node3> {
    private int index;
    private int distance;

    public Node3(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node3 other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class Main5 {

    public static final int INF = (int) 1e9;
    public static int n, m, start;
    public static ArrayList<ArrayList<Node3>> graph = new ArrayList<ArrayList<Node3>>();
    public static int[] d = new int[30001];

    public static void dijkstra(int start) {
        PriorityQueue<Node3> pq = new PriorityQueue<Node3>();
        pq.offer(new Node3(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) {
            Node3 node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();
            if (d[now] < dist) continue;
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = dist + graph.get(now).get(i).getDistance();
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node3(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node3>());
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            graph.get(x).add(new Node3(y, z));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        int cnt = 0;
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] != INF) {
                cnt += 1;
                maxDistance = Math.max(maxDistance, d[i]);
            }
        }

        System.out.println((cnt - 1) + " " + maxDistance);
    }
}
