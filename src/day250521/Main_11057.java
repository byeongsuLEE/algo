package day250521;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-21
 * 풀이방법
 **/
public class Main_11057 {
    private static StringBuilder sb = new StringBuilder();
    private static int N;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solution() {

        int[][] dp = new int[N + 1][10];
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2 ; i<=N;i++){
            for(int j = 0 ; j<=9 ; j++) {
                for(int k = 0 ; k<=j ; k++) {
                    dp[i][j] += dp[i - 1][k] ;
                    dp[i][j] %= 10_007;
                }


            }
        }

        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer = (answer + dp[N][i]) % 10_007;
        }
        sb.append(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

    }
}
