import java.util.Scanner;

class Solution {
    public int solution (String s) {
        int answer = s.length();
        // 1개 단위(step)부터 압축 단위를 늘려가며 확인
        for (int step = 1; step < s.length() / 2 + 1; step++) {
            String compressed = "";
            String prev = s.substring(0, step); // 앞에서부터 step 만큼의 문자열 추출
            int cnt = 1;
            // 단위(step) 크기 만큼 증가시키며 이전 문자열과 비교
            for (int j = step; j < s.length(); j+=step) {
                // 이전과 동일하다면 압축 횟수(cnt) 증가
                String sub = "";
                for (int k = j; k < j + step; k++) {
                    if (k < s.length()) sub += s.charAt(k);
                }
                if (prev.equals(sub)) cnt += 1;
                // 다른 문자열이 나왔다면(더 이상 압축하지 못하는 경우라면)
                else {
                    compressed += (cnt >= 2) ? cnt + prev : prev;
                    sub = "";
                    for (int k = j; k < j + step; k++) {
                        if (k < s.length()) sub += s.charAt(k);
                    }
                    prev = sub; // 다시 상태 초기화
                    cnt = 1;
                }
            }
            // 남아 있는 문자열에 대해서 처리
            compressed += (cnt >= 2) ? cnt + prev : prev;
            // 만들어지는 문자열이 가장 짧은 것이 정답
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        Solution s = new Solution();
        System.out.println(s.solution(str));
    }
