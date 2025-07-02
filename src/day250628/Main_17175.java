package day250628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17175 {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static long callCount = 0;
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solution() {
        fibo(N);  // dp 배열 사용하지 않음
        sb.append(callCount);
    }

    private static long fibo(int n) {
        callCount = (callCount + 1) % MOD;  // 호출 횟수 증가

        if (n < 2) {
            return n;  // 기저 조건
        }

        // 메모이제이션 없이 순수 재귀 (원본 코드와 동일)
        return (fibo(n - 2) + fibo(n - 1)) % MOD;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }
}