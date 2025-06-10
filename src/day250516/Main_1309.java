package day250516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-16
 * 풀이방법
 * 1. dp[N번째][왼쪽/오른쪽/선택x]
 **/

public class Main_1309 {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[][] dp;
    private static final int MOD = 9901;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solution() {
        // dp[i][j]: i번째 행에 j 상태로 사자를 배치하는 경우의 수
        // j=0: 사자를 배치하지 않음
        // j=1: 왼쪽에 사자를 배치
        // j=2: 오른쪽에 사자를 배치

        dp[1][0] = 1; // 첫 행에 사자를 배치하지 않는 경우
        dp[1][1] = 1; // 첫 행 왼쪽에 사자를 배치하는 경우
        dp[1][2] = 1; // 첫 행 오른쪽에 사자를 배치하는 경우

        for (int i = 2; i <= N; i++) {
            // 현재 행에 사자를 배치하지 않는 경우
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;

            // 현재 행 왼쪽에 사자를 배치하는 경우
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;

            // 현재 행 오른쪽에 사자를 배치하는 경우
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }

        // 마지막 행까지 모든 경우의 수를 합산
        int result = (dp[N][0] + dp[N][1] + dp[N][2]) % MOD;
        sb.append(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][3]; // [행][상태]
    }
}