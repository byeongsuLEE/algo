package day250612;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-12
 * 풀이방법
 **/


public class Main_15486 {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[] dp;
    private static int[][] talk;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solution() {

        for (int i = 1; i <= N; i++) {

            dp[i] = Math.max(dp[i] , dp[i-1]);
            int nextIndex = i + talk[i][0];
            if (nextIndex-1 <= N) {
                    dp[nextIndex] = Math.max(dp[nextIndex], dp[i] + talk[i][1]);
            }
        }
//        int answer = Integer.MIN_VALUE;
//        for (int i = 1; i <= N+1; i++) {
//            answer = Math.max(dp[i], answer);
//        }
        sb.append(Math.max(dp[N],dp[N+1]));
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 2];
        talk = new int[N + 1][2]; // [0] : 걸리는 시간  , [1] : 비용

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            talk[i][0] = Integer.parseInt(st.nextToken());
            talk[i][1] = Integer.parseInt(st.nextToken());
        }

    }

}
