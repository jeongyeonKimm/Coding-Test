import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
    private int x;
    private int y;
    private int distance;

    public Position(int x, int y, int distance) {
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
}

public class Main1 {

    public static final int INF = (int) 1e9;
    public static int n;
    public static int nowX = 0, nowY = 0;
    public static int nowSize = 2;
    public static int[][] arr = new int[20][20];
    public static int[][] dist = new int[20][20];
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static int[][] bfs() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = -1;
            }
        }

        Queue<Position> q = new LinkedList<>();

        q.offer(new Position(nowX, nowY, 0));
        dist[nowX][nowY] = 0;

        while (!q.isEmpty()) {
            Position pos = q.poll();
            int x = pos.getX();
            int y = pos.getY();
            int distance = pos.getDistance();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (dist[nx][ny] == -1 && arr[nx][ny] <= nowSize) {
                        dist[nx][ny] = distance + 1;
                        q.offer(new Position(nx, ny, dist[nx][ny]));
                    }
                }
            }
        }

        return dist;
    }

    public static Position find(int[][] dist) {
        int x = 0;
        int y = 0;
        int minDist = INF;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] != -1 && arr[i][j] >= 1 && arr[i][j] < nowSize) {
                    if (dist[i][j] < minDist) {
                        x = i;
                        y = j;
                        minDist = dist[i][j];
                    }
                }
            }
        }

        return new Position(x, y, minDist);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 9) {
                    nowX = i;
                    nowY = j;
                    arr[nowX][nowY] = 0;
                }
            }
        }

        int result = 0;
        int ate = 0;

        while (true) {
            Position pos = find(bfs());
            int x = pos.getX();
            int y = pos.getY();
            int distance = pos.getDistance();
            if (distance == INF) {
                System.out.println(result);
                break;
            }
            else {
                nowX = x;
                nowY = y;
                result += distance;
                arr[nowX][nowY] = 0;
                ate += 1;
                if (ate >= nowSize) {
                    nowSize += 1;
                    ate = 0;
                }
            }
        }
    }
}
