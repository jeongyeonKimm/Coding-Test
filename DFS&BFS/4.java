class Solution {

    public int balancedIndex(String str) {
        int count = 0;  // 왼쪽 괄호의 개수
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') count += 1;
            else count -= 1;
            if (count == 0) return i;
        }
        return -1;
    }

    public boolean checkProper(String str) {
        int count = 0;  // 왼쪽 괄호의 개수
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') count += 1;
            else {
                if (count == 0) {   // 쌍이 맞지 않는 경우에 false 반환
                    return false;
                }
                count -= 1;
            }
        }
        return true;    // 쌍이 맞는 경우에 true 반환
    }

    public String solution(String p) {
        String answer = "";
        if (p.equals("")) return answer;
        int index = balancedIndex(p);
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);
        // "올바른 괄호 문자열"이면, v에 대해 함수를 수행한 결과를 붙여 반환
        if (checkProper(v)) {
            answer = u + solution(v);
        }
        // "올바른 괄호 문자열"이 아니라면 아래의 과정을 수행
        else {
            answer = "(";
            answer += solution(v);
            answer += ")";
            u = u.substring(1, u.length() - 1);
            String tmp = "";
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') tmp += ")";
                else tmp += "(";
            }
            answer += tmp;
        }
        return answer;
    }
}

public class Main4 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("(()())()"));
    }
}
