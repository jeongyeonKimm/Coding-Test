import java.util.*;

class Virus implements Comparable<Virus> {

    private int index;
    private int second;
    private int x;
    private int y;

    public Virus(int index, int second, int x, int y) {
        this.index = index;
        this.second = second;
        this.x = x;
        this.y = y;
    }

    public int getIndex() {
        return index;
    }

    public int getSecond() {
        return second;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // 번호가 낮은 순서로 정렬
    @Override
    public int compareTo(Virus other) {
        if (this.index < other.index) {
            return -1;
        }
        return 1;
    }
}

public class Main3 {

    public static int n, k;
    public static int[][] graph = new int[200][200];
    public static ArrayList<Virus> viruses = new ArrayList<>();

    // 바이러스가 퍼져나갈 수 있는 4가지의 위치
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] != 0) {
                    viruses.add(new Virus(graph[i][j], 0, i, j));
                }
            }
        }

        // 정렬 이후에 큐로 옮기기 (낮은 번호의 바이러스가 먼저 증식하므로)
        Collections.sort(viruses);
        Queue<Virus> q = new LinkedList<Virus>();
        for (int i = 0; i < viruses.size(); i++) {
            q.offer(viruses.get(i));
        }

        int s = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        while (!q.isEmpty()) {
            Virus virus = q.poll();
            if (virus.getSecond() == s) break;
            for (int i = 0; i < 4; i++) {
                int nx = virus.getX() + dx[i];
                int ny = virus.getY() + dy[i];
                // 해당 위치로 이동할 수 있는 경우
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    // 아직 방문하지 않은 위치라면, 그 위치에 바이러스 넣기
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = virus.getIndex();
                        q.offer(new Virus(virus.getIndex(), virus.getSecond() + 1, nx, ny));
                    }
                }
            }
        }

        System.out.println(graph[x - 1][y - 1]);
    }
}
