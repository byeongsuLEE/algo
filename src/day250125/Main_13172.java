package day250125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-01-25
 * 풀이방법 : 분수의 합을 모듈러 연산을 이용해 계산
 **/

public class Main_13172 {
    private static int M;
    private static long A, B; // 분자(A), 분모(B)
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        // B-1: 분모의 역원 구하기
        long reverseB = getReverseB();

        // 결과 계산: (A * B-1) % MOD
        System.out.println(A * reverseB % MOD);
    }

    // 모듈러 곱셈 역원 계산 (페르마의 소정리 사용)
    private static long getReverseB() {
        return power(B, MOD - 2);
    }

    // 분할 정복을 이용한 거듭제곱
    private static long power(long base, int exp) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) { // 홀수일 때
                result = result * base % MOD;
            }
            base = base * base % MOD; // 제곱
            exp /= 2;
        }
        return result;
    }

    // 입력 초기화
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        M = Integer.parseInt(br.readLine()); // 주사위 개수
        A = 0; // 초기 분자
        B = 1; // 초기 분모 (1로 시작)

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken()); // 면의 개수 (분모)
            long s = Long.parseLong(st.nextToken()); // 면의 합 (분자)

            // 분수를 통합 (통분)
            A = A * n + s * B; // 새로운 분자
            B = B * n;         // 새로운 분모

            // 중간 계산값을 모듈러로 제한
            A %= MOD;
            B %= MOD;
        }
    }
}
