import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node2 implements Comparable<Node2> {
    private int index;
    private int distance;

    public Node2(int index, int distance) {
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
    public int compareTo(Node2 other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class Main4 {

    public static final int INF = (int) 1e9;
    public static int n, m;
    public static int start = 1;
    public static ArrayList<ArrayList<Node2>> graph = new ArrayList<ArrayList<Node2>>();
    public static int[] d = new int[20001];

    public static void dijkstra(int start) {
        PriorityQueue<Node2> pq = new PriorityQueue<>();
        pq.offer(new Node2(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) {
            Node2 node2 = pq.poll();
            int dist = node2.getDistance();
            int now = node2.getIndex();
            if (d[now] < dist) continue;
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node2(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node2>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(new Node2(b, 1));
            graph.get(b).add(new Node2(a, 1));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        int maxNode = 0;
        int maxDistance = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (maxDistance < d[i]) {
                maxNode = i;
                maxDistance = d[i];
                result.clear();
                result.add(maxNode);
            }
            else if (maxDistance == d[i]) {
                result.add(i);
            }
        }

        System.out.println(maxNode + " " + maxDistance + " " + result.size());
    }
}
