package day250508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-08
 * 풀이방법
 **/


public class Main_12852 {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[] dp;
    private static int[] num;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solution() {

        dp = new int[N + 1];
        num = new int[N + 1];

        // 상태 : 결과 숫자, 횟수, 고른 수

        //dp[계산결과] = 횟수


        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            num[i] = i - 1;

            // 2로 나누어 떨어지는 경우
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                num[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                num[i] = i / 3;
            }


        }
        sb.append(dp[N]).append("\n");
        int start = N;
        while (start > 0) {
            sb.append(start).append(" ");
            start = num[start];
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


    }

}
