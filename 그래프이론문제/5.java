import java.util.*;

public class Main5 {

    public static int testCase, n, m;
    public static int[] indegree = new int[501];    // 모든 노드에 대한 진입 차수는 0으로 초기화
    public static boolean[][] graph = new boolean[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            Arrays.fill(indegree, 0);

            for (int j = 0; j < 501; j++) {
                Arrays.fill(graph[j], false);
            }

            n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                arr.add(sc.nextInt());
            }

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    graph[arr.get(j)][arr.get(k)] = true;
                    indegree[arr.get(k)] += 1;
                }
            }

            m = sc.nextInt();
            for (int j = 0; j < m; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (graph[a][b]) {
                    graph[a][b] = false;
                    graph[b][a] = true;
                    indegree[a] += 1;
                    indegree[b] -= 1;
                }
                else {
                    graph[a][b] = true;
                    graph[b][a] = false;
                    indegree[a] -= 1;
                    indegree[b] += 1;
                }
            }

            ArrayList<Integer> result = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();

            for (int j = 1; j <= arr.size(); j++) {
                if (indegree[j] == 0) {
                    q.offer(j);
                }
            }

            boolean certain = true; // 위상 정렬 결과가 오직 하나인지의 여부
            boolean cycle = false; // 그래프 내 사이클이 존재하는지 여부

            for (int j = 0; j < n; j++) {
                if (q.size() == 0) {
                    cycle = true;
                    break;
                }
                if (q.size() >= 2) {
                    certain = false;
                    break;
                }
                int now = q.poll();
                result.add(now);
                for (int k = 1; k <= n; k++) {
                    if (graph[now][k]){
                        indegree[k] -= 1;
                        if (indegree[k] == 0) {
                            q.offer(k);
                        }
                    }
                }
            }

            if (cycle) System.out.println("IMPOSSIBLE");
            else if (!certain) System.out.println("?");
            else {
                for (int j = 0; j < result.size(); j++) {
                    System.out.print(result.get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
