class Node implements Comparable<Node> {
    private int stage;
    private double fail;

    public Node(int stage, double fail) {
        this.stage = stage;
        this.fail = fail;
    }

    public int getStage() {
        return stage;
    }

    @Override
    public int compareTo(Node other) {
        if (this.fail == other.fail) {
            return Integer.compare(this.stage, other.stage);
        }
        return Double.compare(other.fail, this.fail);
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<Node> arr = new ArrayList<>();
        int length = stages.length;

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) {
                    cnt += 1;
                }
            }

            double fail = (double) cnt / length;
            arr.add(new Node(i, fail));
            length -= cnt;
        }

        Collections.sort(arr);

        for (int i = 0; i < N; i++) {
            answer[i] = arr.get(i).getStage();
        }

        return answer;
    }
}

public class Main3 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] result = sol.solution(5, stages);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
