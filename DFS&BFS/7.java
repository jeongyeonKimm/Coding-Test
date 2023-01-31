import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position2 {
    private int x;
    private int y;

    public Position2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main7 {

    public static int n, l, r;
    public static int totalCount = 0;

    public static int[][] graph = new int[50][50];
    public static int[][] unions = new int[50][50];

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    // 특정 위치에서 출발하여 모든 연합을 체크한 뒤에 데이터 갱신
    public static void process(int x, int y, int index) {
        // (x, y)의 위치와 연결된 나라(연합) 정보를 담는 리스트
        ArrayList<Position2> united = new ArrayList<Position2>();
        united.add(new Position2(x, y));
        // 너비 우선 탐색 (BFS)을 위한 큐 라이브러리 사용
        Queue<Position2> q = new LinkedList<>();
        q.offer(new Position2(x, y));
        unions[x][y] = index;   // 현재 연합의 번호 할당
        int summary = graph[x][y];  // 현재 연합의 전체 인구 수
        int count = 1;   // 현재 연합의 국가 수
        while (!q.isEmpty()) {
            Position2 pos = q.poll();
            x = pos.getX();
            y = pos.getY();
            // 현재 위치에서 4가지 방향을 확인하며
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 바로 옆에 있는 나라를 확인하여
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && unions[nx][ny] == -1) {
                    // 옆에 있는 나라와 인구 차이가 L명 이상, R명 이하라면
                    int gap = Math.abs(graph[nx][ny] - graph[x][y]);
                    if (gap >= l && gap <= r) {
                        q.offer(new Position2(nx, ny));
                        // 연합에 추가하기
                        unions[nx][ny] = index;
                        summary += graph[nx][ny];
                        count += 1;
                        united.add(new Position2(nx, ny));
                    }
                }
            }
        }
        // 연합 국가끼리 인구를 분배
        for (int i = 0; i < united.size(); i++) {
            x = united.get(i).getX();
            y = united.get(i).getY();
            graph[x][y] = summary / count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // 더 이상 인구 이동을 할 수 없을 때까지 반복
        while (true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    unions[i][j] -= 1;
                }
            }
            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (unions[i][j] == -1) {
                        process(i, j, index);
                        index += 1;
                    }
                }
            }
            // 모든 인구 이동이 끝난 경우
            if (index == n * n) break;
            totalCount += 1;
        }

        System.out.println(totalCount);
    }
}
