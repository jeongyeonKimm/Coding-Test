import java.util.ArrayList;
import java.util.Collections;

class Node2 implements Comparable<Node2> {
    private int x;
    private int y;
    private int a;

    public Node2(int x, int y, int a) {
        this.x = x;
        this.y = y;
        this.a = a;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getA() {
        return a;
    }

    @Override
    public int compareTo(Node2 other) {
        if (this.x == other.x && this.y == other.y) {
            return Integer.compare(this.a, other.a);
        }
        if (this.x == other.x) {
            return Integer.compare(this.y, other.y);
        }
        return Integer.compare(this.x, other.x);
    }
}

class Solution3 {
    // 현재 설치된 구조물이 가능한 구조물인지 확인하는 함수
    public boolean possible(ArrayList<ArrayList<Integer>> answer) {
        for (int i = 0; i < answer.size(); i++) {
            int x = answer.get(i).get(0);
            int y = answer.get(i).get(1);
            int a = answer.get(i).get(2);
            if (a == 0) {   // '기둥'인 경우
                boolean check = false;
                // '바닥 위'라면 정상
                if (y == 0) check = true;
                // '보의 한 쪽 끝 부분 위' 혹은 '다른 기둥 위'라면 정상
                for (int j = 0; j < answer.size(); j++) {
                    if (x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) {
                        check = true;
                    }
                    if (x == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) {
                        check = true;
                    }
                    if (x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)) {
                        check = true;
                    }
                }
                if (!check) return false;
            }
            else if (a == 1) {  // '보'인 경우
                boolean check = false;
                boolean left = false;
                boolean right = false;
                // '한쪽 끝부분이 기둥 위' 혹은 '양쪽 끝부분이 다른 보와 동시에 연결'이라면 정상
                for (int j = 0; j < answer.size(); j++) {
                    if (x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)) {
                        check = true;
                    }
                    if (x + 1 == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)) {
                        check = true;
                    }
                    if (x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) {
                        left  = true;
                    }
                    if (x + 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) {
                        right = true;
                    }
                }
                if (left && right) check = true;
                if (!check) return false;
            }
        }
        return true;
    }

    public int[][] solution(int n, int[][] build_frame) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];

            if (b == 0) {   // 삭제하는 경우
                // 일단 삭제해본 뒤
                int index = 0;
                for (int j = 0; j < answer.size(); j++) {
                    if (x == answer.get(j).get(0) && y == answer.get(j).get(1) && a == answer.get(j).get(2)) {
                        index = j;
                    }
                }
                ArrayList<Integer> erased = answer.get(index);
                answer.remove(index);
                if (!possible(answer)) {
                    answer.add(erased); // 가능한 구조물이 아니면 다시 설치
                }
            }
            if (b == 1) {   // 설치하는 경우
                // 일단 설치해본 뒤
                ArrayList<Integer> inserted = new ArrayList<Integer>();
                inserted.add(x);
                inserted.add(y);
                inserted.add(a);
                answer.add(inserted);
                if (!possible(answer)) {
                    answer.remove(answer.size() - 1);   // 가능한 구조물이 아니면 다시 삭제
                }
            }
        }

        // 정렬 수행
        ArrayList<Node2> ans = new ArrayList<Node2>();
        for (int i = 0; i < answer.size(); i++) {
            ans.add(new Node2(answer.get(i).get(0), answer.get(i).get(1), answer.get(i).get(2)));
        }
        Collections.sort(ans);

        // 배열로 바꾸어 반환
        int[][] res = new int[ans.size()][3];
        for (int i = 0; i < ans.size(); i++) {
            res[i][0] = ans.get(i).getX();
            res[i][1] = ans.get(i).getY();
            res[i][2] = ans.get(i).getA();
        }

        return res;
    }
}

public class Main6 {
    public static void main(String[] args) {
        Solution3 sol3 = new Solution3();

        int n = 5;
        int[][] build_frame = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};

        int[][] result = sol3.solution(n, build_frame);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
