import java.util.Scanner;

public class Main4 {
    public static int n, m, x, y, direction;

    public static int[][] visited = new int[50][50];
    public static int[][] map = new int[50][50];

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    private static void turnLeft() {
        direction -= 1;
        if (direction == -1) {
            direction = 3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        x = sc.nextInt();
        y = sc.nextInt();
        direction = sc.nextInt();
        visited[x][y] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int cnt = 1;
        int turn_time = 0;
        while (true) {
            turnLeft();
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (visited[nx][ny] == 0 && map[nx][ny] == 0) {
                visited[nx][ny] = 1;
                x = nx;
                y = ny;
                cnt++;
                turn_time = 0;
            }
            else {
                turn_time += 1;
            }
            if (turn_time == 4) {
                nx = x - dx[direction];
                ny = y - dy[direction];
                if (map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                }
                else {
                    break;
                }
                turn_time = 0;
            }
        }

        System.out.println(cnt);
    }
}
