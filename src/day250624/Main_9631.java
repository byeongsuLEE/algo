package day250624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-24
 * 풀이방법: ? 연속 구간을 찾아서 양쪽 알파벳에 따라 경우의 수 계산
 **/

public class Main_9631 {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static char[] input;
    private static final long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        initAndSolution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }

    private static void solution() {
        long result = 1;
        int i = 0;

        while (i < input.length) {
            if (input[i] == '?') {
                // ? 연속 구간의 시작
                int start = i;
                int questionCount = 0;

                // ? 개수 세기
                while (i < input.length && input[i] == '?') {
                    questionCount++;
                    i++;
                }

                // 왼쪽과 오른쪽 알파벳 찾기
                char left = (start > 0) ? input[start - 1] : '?';
                char right = (i < input.length) ? input[i] : '?';

                // 경우의 수 계산
                long cases = calculateCases(questionCount, left, right);
                result = (result * cases) % MOD;
            } else {
                i++;
            }
        }

        sb.append(result).append("\n");
    }

    private static long calculateCases(int questionCount, char left, char right) {
        // 양쪽이 모두 없는 경우 (처음이나 끝)
        if (left == '?' && right == '?') {
            return 1;
        }

        // 한쪽만 있는 경우
        if (left == '?' || right == '?') {
            return 1;
        }

        // 양쪽 알파벳이 같은 경우
        if (left == right) {
            return 1;
        }

        // 양쪽 알파벳이 다른 경우
        return questionCount + 1;
    }

    private static void initAndSolution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            input = line.toCharArray();
            solution();
        }
    }
}